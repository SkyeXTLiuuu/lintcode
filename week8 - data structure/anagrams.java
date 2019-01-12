/**
* Anagrams
* Given an array of strings, return all groups of strings that are anagrams.
* e.g. Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"]
* e.g. Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"]
* HashMap + sort
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
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < strs.length; i ++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if (!map.containsKey(s)) {
                ArrayList<String> list = new ArrayList<>();
                map.put(s, list);
            }
            map.get(s).add(strs[i]); // 每个anagram会被加到相同key的底下
        }

        for (String s: map.keySet()) {
            if (map.get(s).size() >= 2) {
                result.addAll(map.get(s));
            }
        }

        return result;
    }
}
