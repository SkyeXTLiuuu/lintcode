/**
* Paint Fence
* Paint all the posts such that no more than two adjacent fence posts have the same color.
* Return the total number of ways you can paint the fence.
* Dynamic Programming
* 最多两个fence颜色相同
* 假设 i和 i - 1不同，结果就是(k-1) * dp[i - 1]
* 假设 i和 i - 1相同，那么i-1 和 i-2 肯定不同，结果就是(k-1) * dp[i - 2]
* dp[i]: count # of ways to paint 前n个fence  (k - 1) * (dp[i - 1] + dp[i - 2])
*
* Time complexity: O(n)
* Space complexity: O(n)
*/

public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */

    public int numWays(int n, int k) {
        // write your code here
        if (n == 0 || k == 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        int[] ways = new int[n + 1];
        ways[0] = 0;
        ways[1] = k;
        ways[2] = k * k;

        for (int i = 3; i < n + 1; i ++) {
            ways[i] = (k - 1) * (ways[i - 1] + ways[i - 2]);
        }

        return ways[n];
    }
}
