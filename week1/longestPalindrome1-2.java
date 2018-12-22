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
        Set<Character> oddCount = new HashSet<>();
        // only characters appear odd times remainedi in the set
        for(int i = 0; i < s.length(); i ++){
            Character cur = s.charAt(i);
            if(oddCount.contains(cur)){
                oddCount.remove(cur);
            }
            else{
                oddCount.add(cur);
            }
        }
        int removed = oddCount.size();
        // if removed = 0, "aaaa", then we do not need to add 1 any more 
        if(removed > 0){
            removed = removed - 1;
        }
        return s.length() - removed;
    }
}
