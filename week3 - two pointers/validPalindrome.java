/**
* Valid Palindrome II
* Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
* Time complexity: O(n)
*/

public class Solution {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return checkisPalindrome(s, left + 1, right) || checkisPalindrome(s, left, right - 1);
            }
            left ++;
            right --;
        }
        return true;
    }

    public boolean checkisPalindrome(String s, int left, int right){
        if (s == null || s.length() == 0) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
