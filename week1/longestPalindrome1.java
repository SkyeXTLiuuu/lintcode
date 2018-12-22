/**
* Longest Palindrome
* Find the length of the longest palindromes that can be built with the letters in the String
* example: s = "abccccdd", return 7 ("dccaccd")
* This is case sentitive ("Aa" is not a palindrome)
*/

public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        // store ascii value
        int[] count = new int[58];
        int result = 0;
        for(int i = 0; i < s.length(); i ++){
            count[s.charAt(i) - 'A'] ++;
        }
        for(int i = 0; i < count.length; i ++){
            if(count[i] > 1){
              // we always want to add even number
                result = result + (count[i] / 2) * 2;
            }
        }
        // "aaa" => 2 + 1 = 3; "aaaa" => 4
        return result == s.length() ? result : result + 1;
    }
}
