/**
* Valid Parentheses
* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
* example: "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
* Time complexity: O(n)
* Space complexity: O(1)
*/

public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here

        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> parentheses = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                parentheses.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' && (parentheses.isEmpty() || parentheses.pop() != '(')) {
                return false;
            }
            else if (s.charAt(i) == ']' && (parentheses.isEmpty() || parentheses.pop() != '[')) {
                return false;
            }
            else if (s.charAt(i) == '}' && (parentheses.isEmpty() || parentheses.pop() != '{')) {
                return false;
            }
        }

        return parentheses.isEmpty();
    }
}
