/**
* Palindrome Partitioning
* Given a string s, partition s such that every substring of the partition is a palindrome.
* Time complexity: ?
* DFS + DP
*/

public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        boolean[][] isPalindrome = getPalindrome(s);
        List<Integer> partition = new ArrayList<>();
        dfs(s, 0, partition, results, isPalindrome);
        return results;
    }

    public void dfs(String s, int startIndex, List<Integer> partition, List<List<String>> results, boolean[][] isPalindrome) {
        if (startIndex == s.length()) {
            addResult(results, partition, s);
            return ;
        }
        for (int i = startIndex; i < s.length(); i ++) {
            if (!isPalindrome[startIndex][i]){
                continue;
            }
            partition.add(i);
            dfs(s, i + 1, partition, results, isPalindrome);
            partition.remove(partition.size() - 1);
        }
    }

    public void addResult(List<List<String>> results, List<Integer> partition, String s) {
        int startIndex = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < partition.size(); i ++) {
            list.add(s.substring(startIndex, partition.get(i) + 1));
            startIndex = partition.get(i) + 1;
        }
        results.add(list);
    }

    public boolean[][] getPalindrome(String s) {
        int length = s.length();
        boolean[][] palindrome = new boolean[length][length];
        for (int i = 0; i < length; i ++) {
            palindrome[i][i] = true;
        }
        for (int i = 0; i < length - 1; i ++) {
            palindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int i = length - 3; i >= 0; i --) {
            for (int j = i + 2; j < length; j ++) {
                palindrome[i][j] = (s.charAt(i) == s.charAt(j)) && (palindrome[i + 1][j - 1]);
            }
        }
        return palindrome;
    }
}
