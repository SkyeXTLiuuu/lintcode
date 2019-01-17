/**
* Maximum Subarray
* Given an array of integers, find a contiguous subarray which has the largest sum.
* Greedy Algorithm
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] A) {
        // write your code here
        if (A == null || A.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0); // 如果所有的数都大于0，那肯定是越加越大
        }

        return max;
    }
}
