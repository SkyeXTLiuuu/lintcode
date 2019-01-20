/**
* Power of Two
* Given an integer, write a function to determine if it is a power of two.
* Input: n = 0 Output: false
* 最大的2^x integer是 2^31. 那么找到这个数, 一定可以被n整除. 一步到位.
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

        return Math.pow(2, 31) % n == 0;
    }
}
