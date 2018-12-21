/**
* Longest Palindromic Substring
* Given a string S, find the longest palindromic substring in S.
* dynamic programming
* Time complexity: O(n^2) + space complexity: O(n ^ 2)
*/

public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        // record the checked substring
        boolean[][] palindrome = new boolean[n][n];
        int start = 0;
        int longest = 1;
        // initializling mark for one letter
        for(int i = 0; i < n; i ++){
            palindrome[i][i] = true;
        }
        // initializling mark for two letters
        for(int i = 0; i < n - 1; i ++){
            if(s.charAt(i) == s.charAt(i + 1)){
                longest = 2;
                start = i;
                palindrome[i][i + 1] = true;
            }
        }
        for(int i = n - 3; i >= 0; i --){
            for(int j = i + 2; j < n; j ++){
              // mark new substrings based on existing results 
                palindrome[i][j] = palindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if(palindrome[i][j] && j - i + 1 > longest){
                    longest = j - i + 1;
                    start = i;
                }
            }

        }
        return s.substring(start, start + longest);
    }
}
