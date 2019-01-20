/**
* Power of Three
* Given an integer, write a function to determine if it is a power of three.
* Input: n = 0 Output: false
* Binary Search
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

        int start = 0;
        int end = n;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            long powOfThree = (long) Math.pow(3, mid);
            if (powOfThree == n) {
                return true;
            }
            else if(powOfThree < n) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        return Math.pow(3, start) == n;
    }
}
