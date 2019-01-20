/**
* Power of Two
* Given an integer, write a function to determine if it is a power of two.
* Input: n = 0 Output: false
* Binary Search
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

        int start = 0;
        int end = n;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            long powOfTwo = (long) Math.pow(2, mid);
            if (powOfTwo == n) {
                return true;
            }
            else if(powOfTwo < n) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        return Math.pow(2, start) == n;
    }
}
