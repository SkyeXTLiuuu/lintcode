/**
* Maximum Subarray
* Given an array of integers, find a contiguous subarray which has the largest sum.
* Prefix sum 
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i ++)  {
            sum = sum + nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
}
