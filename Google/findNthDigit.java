/**
* Nth Digit
* Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
* example: input 3 => output 3; input 11 => output 0 (1'0')
* Time complexity:
* Space complexity:
*/

public class Solution {
    /**
     * @param n: a positive integer
     * @return: the nth digit of the infinite integer sequence
     */
    public int findNthDigit(int n) {
        // write your code here
        long count = 9; // how many numbers within the current digit (1-9) 9 => (10-99) 90
        int len = 1; // length of the current digits 1 (3) - 2 (22) - 3 (100)
        int start = 1; // the starting number of the current digit range 1 - 10 - 100

        // find the range of n
        while (n > count * len) {
            n = (int) (n - count * len); // the total number of digits in the range
            count = count * 10;
            len ++;
            start = start * 10;
        }

        int num = start + (n - 1) / len; // (n - 1) / len is the kth number to change from the order in digits to the order in number, add start to get the exact number, minus 1 to change from "th" to index
        int index = 0 + (n - 1) % len; // get the "th" digit in the number
        return String.valueOf(num).charAt(index) - '0';

    }
}
