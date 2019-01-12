/**
* Anagrams
* Given an array of strings, return all groups of strings that are anagrams.
* e.g. Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"]
* e.g. Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"]
* hash function 
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        for (String str: strs) {
            int[] count = new int[26];
            // 统计每个字幕出现的频率
            for (int i = 0; i < str.length(); i ++) {
                count[str.charAt(i) - 'a'] ++;
            }

            int hash = getHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }

            map.get(hash).add(str);
        }

        for (ArrayList<String> tmp: map.values()) {
            if (tmp.size() > 1) {
                result.addAll(tmp);
            }
        }

        return result;
    }

    private int getHash(int[] count) {
        int hash = 0;
        int a = 378551;
        int b = 63689;
        for (int num: count) {
            hash = hash * a + num;
            a = a * b;
        }

        return hash;
    }
}
