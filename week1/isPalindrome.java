/**
* Valid Palindrome
* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
* example: "A man, a plan, a canal: Panama" is a palindrome.
* "race a car" is not a palindrome.
* Medium
*/

public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if(s == null || s.trim().length() == 0){
            return true;
        }
        StringBuilder updatedS = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c)){
                updatedS.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return checkPalindrom(updatedS.toString());
    }

    public boolean checkPalindrom(String s){
        if(s == null || s.trim().length() == 0){
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j --;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
