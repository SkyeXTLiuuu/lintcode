/**
* Plus One
* Given a non-negative number represented as an array of digits, plus one to the number.
* example: Given [1,2,3] which represents 123, return [1,2,4].
* Time complexity: O(n)
* Space complexity: O(1)
*/

public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here

        if (digits == null || digits.length == 0) {
            return digits;
        }

        int remain = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            int digit = digits[i] + remain;
            remain = digit / 10;
            digits[i] = digit % 10;
        }

        if (remain == 0) {
            return digits;
        }

        int[] plusOne = new int[digits.length + 1];
        plusOne[0] = remain;
        for (int i = 1; i < plusOne.length; i ++) {
            plusOne[i] = digits[i - 1];
        }
        return plusOne;
    }
}
