/**
* Longest Palindromic Substring
* Given a string S, find the longest palindromic substring in S.
* Suffix Array
* Time complexity: O(nlogn)
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
        // abc => #a#b#c
        String str = generateString(s);
        int n = str.length();
        int[] palindrome = new int[n];
        int mid = 0; // the midpoint index
        int longest = 1; // the length from the midpoint to the start, i.e. half of the substring
        palindrome[0] = 1;
        for(int i = 1; i < n; i ++){
            int len = 1;
            if(mid + longest > i){
                int mirrorOfI= mid - (i - mid); // get the beginning of the substring
                len = Math.min(palindrome[mirrorOfI], mid + longest - i); // check the unchecked part
            }
            while(i + len < n && i - len >= 0){
                if(str.charAt(i - len) != str.charAt(i + len)){
                    break;
                }
                len ++;
            }
            if(len > longest){
                longest = len;
                mid = i;
            }
            palindrome[i] = len;
        }
        longest = longest - 1; // remove the extra #
        int start = (mid - 1) / 2 - (longest - 1) / 2;
        return s.substring(start, start + longest);
    }

    public String generateString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        return sb.toString();
    }
}
