/**
* Power of Two
* Given an integer, write a function to determine if it is a power of two.
* Input: n = 0 Output: false
* Time complexity: O(logn)
* Space complexity: O(1)
*/


public class Solution {
    /**
     * @param n: an integer
     * @return: if n is a power of two
     */
    public boolean isPowerOfTwo(int n) {
        // Write your code here
        if (n == 0) {
            return false;
        }

        int remain = 0;
        while (n != 1) {
            remain = n % 2;
            if (remain != 0) {
                return false;
            }
            n = n / 2;
        }

        return remain == 0;
    }
}
