/**
* Longest Palindromic Substring
* Given a string S, find the longest palindromic substring in S.
* enumeraion method
* Time complexity: O(n^2)
* Medium
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
        int start = 0;
        int len = 0;
        int longest = 0;
        for(int i = 0; i < s.length(); i ++){
          // if the substring has one centered element in the middle e.g. "aba"
            len = findLongestPalindrome(s, i, i);
            if(len > longest){
                longest = len;
                start = i - len / 2;
            }
          // if the substring is a complete palindrome "abba"
            len = findLongestPalindrome(s, i, i + 1);
            if(len > longest){
                longest = len;
                start = i - len / 2 + 1;
            }
        }
        return s.substring(start, start + longest);
    }

    /**
    * Get the length of the longest palindrome centered at left and right
    */
    public int findLongestPalindrome(String s, int left, int right){
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = 0;
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                return len;
            }
            len += left == right ? 1 : 2;
            left --;
            right ++;
        }
        return len;
    }
}
