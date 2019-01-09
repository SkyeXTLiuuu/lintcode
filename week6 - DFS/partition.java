/**
* Palindrome Partitioning
* Given a string s, partition s such that every substring of the partition is a palindrome.
* Time complexity: ?
* DFS
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
        List<String> partition = new ArrayList<>();
        dfs(s, 0, partition, results);
        return results;
    }

    public void dfs(String s, int startIndex, List<String> partition, List<List<String>> results) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<String>(partition));
            return ;
        }
        for (int i = startIndex; i < s.length(); i ++) {
            String substring = s.substring(startIndex, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            }
            partition.add(substring);
            dfs(s, i + 1, partition, results);
            partition.remove(partition.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
