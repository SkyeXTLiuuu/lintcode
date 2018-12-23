/**
* Longest Palindromic Substring
* Given a string S, find the longest palindromic substring in S.
* Suffix Array
* Time complexity: O(nlogn)
* Medium
*/

/**
* Manacher Algorithm
* radius
* char: # a # b # a #
* RL:   1 2 1 4 1 2 1
* RL-1: 0 1 0 3 0 1 0
*
* char: # a # b # b # a #
* RL:   1 2 1 2 5 2 1 2 1
* RL-1: 0 1 0 1 4 1 0 1 0
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
        // abc => #a#b#c 解决长度奇偶性带来的对称轴的问题
        String str = generateString(s);
        int n = str.length();
        int[] palindrome = new int[n];
        int mid = 0; // the midpoint index
        int longest = 1; // the length from the midpoint to the start, i.e. half of the substring
        palindrome[0] = 1;
        for(int i = 1; i < n; i ++){
            int len = 1;
            // mid + longest is the index of the maxright
            // if i is on the left of the maxright, its palindrome will have some similarity with its mirror version
            if(mid + longest > i){
                int mirrorOfI= mid - (i - mid); // get mirror of i from the recorded mid position
                // if the palindrome of mirror is within the range of the maxright, len will be at least palindrome[mirrorOfI]
                // if the palindrome of mirror is beyond the range of the maxright, we only guarantee the len from i to rightmax
                len = Math.min(palindrome[mirrorOfI], mid + longest - i); // check the unchecked part
            }
            // we get a starting len, we compare further left and right
            while(i + len < n && i - len >= 0){
                if(str.charAt(i - len) != str.charAt(i + len)){
                    break;
                }
                len ++;
            }
            // update len 
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

    // 变完之后的长度永远是奇数
    // abc => #a#b#c# abcd =>#a#b#c#d#
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
