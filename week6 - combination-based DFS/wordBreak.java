public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        if (s == null) {
            return null;
        }
        Map<String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
        return dfs(s, wordDict, memo);
    }

    public List<String> dfs(String s, Set<String> wordDict, Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        ArrayList<String> results = new ArrayList<String>();
        if (s.length() == 0) {
            return results;
        }

        if (wordDict.contains(s)) {
            results.add(s);
        }

        for (int len = 1; len < s.length(); ++ len) {
            String word = s.substring(0, len);
            if (!wordDict.contains(word)) {
                continue;
            }
            String suffix = s.substring(len);
            List<String> segmentations = dfs(suffix, wordDict, memo);

            for (String segmentation: segmentations) {
                results.add(word + " " + segmentation);
            }
        }
        memo.put(s, results);
        return results;
    }
}
