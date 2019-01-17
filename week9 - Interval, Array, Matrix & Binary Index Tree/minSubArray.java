/**
* Minimum Subarray
* Given an array of integers, find the subarray with smallest sum.
* Prefix sum
* 相当于maximum subarray 只不过先把所有的值*(-1) 然后算出最大的结果之后再翻转回来 变成最小的
*/

public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        for (int i = 0; i < nums.size(); i ++) {
            nums.set(i, nums.get(i) * (-1));
        }

        int max = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;

        for (int i = 0; i < nums.size(); i ++)  {
            sum = sum + nums.get(i);
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max * (-1);
    }
}
