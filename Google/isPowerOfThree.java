/**
* Power of Three
* Given an integer, write a function to determine if it is a power of three.
* Input: n = 0 Output: false
* Time complexity: O(logn)
* Space complexity: O(1)
*/

public class Solution {
    /**
     * @param n: an integer
     * @return: if n is a power of three
     */
    public boolean isPowerOfThree(int n) {
        // Write your code here
        if (n == 0) {
            return false;
        }

        int remain = 0;
        while (n != 1) {
            remain = n % 3;
            if (remain != 0) {
                return false;
            }
            n = n / 3;
        }

        return remain == 0;
    }
}
