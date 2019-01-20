/**
* Power of Three
* Given an integer, write a function to determine if it is a power of three.
* Input: n = 0 Output: false
* 最大的3^x integer是 3^19. 那么找到这个数, 一定可以被n整除. 一步到位.
* Time complexity: O(1)
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

        return Math.pow(3, 19) % n == 0;
    }
}
