/**
* Add Strings
* Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
* example: Given num1 = "123", num2 = "45" return "168"
*/

public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        if (num1 == null || num2 == null) {
            return "";
        }

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        String result = "";
        int remainder = 0;

        while(index1 >= 0 || index2 >= 0) {
            int c1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int c2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int sum = c1 + c2 + remainder;
            result = sum % 10 + result;
            remainder = sum / 10;
            index1 --;
            index2 --;
        }

        if (remainder != 0) {
            result = remainder + result;
        }

        return result;
    }
}
