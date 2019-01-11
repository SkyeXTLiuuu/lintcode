/**
* Word Pattern II
* Given a pattern and a string str, find if str follows the same pattern.
* Time complexity: ?
* iteration
*/

public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return match(pattern, str, map, set);
    }

    private boolean match (String pattern, String str, Map<Character, String> map, Set<String> set) {
        // 一个被截没了，另一个也没了
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        Character c = pattern.charAt(0); // pattern 当前位置的代表
        // 以前出现过这个代表
        if (map.containsKey(c)) {
            // 如果他在 str里面对应的位置不在开头
            if (!str.startsWith(map.get(c))) {
                return false;
            }
            // 往后挪
            return match(pattern.substring(1), str.substring(map.get(c).length()), map, set);
        }

        // 如果以前没出现过这个代表
        for (int i = 0; i < str.length(); i ++) {
            // 随机从str的开头提取可以配对的词，如果这个词已经被之前别的key配对走了，continue
            String word = str.substring(0, i + 1);
            if (set.contains(word)) {
                continue;
            }

            map.put(c, word);
            set.add(word);
            if (match(pattern.substring(1), str.substring(i + 1), map, set)) {
                return true;
            }

            set.remove(word);
            map.remove(c);
        }
        return false;
    }
}
