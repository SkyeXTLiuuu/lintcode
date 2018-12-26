/**
* Window Sum
* Find the sum of the element inside the window at each moving
* example: [1,2,7,8,5], k = 3 => [10,17,20]
* Time complexity: O(n)
*/

public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return new int[0];
        }
        int length = nums.length;
        int[] sum = new int[length - k + 1];
        int left = 0;
        int right = 0;
        int curSum = 0;
        while (right < k) {
            curSum = curSum + nums[right];
            right ++;
        }
        sum[left] = curSum;
        while (right < length) {
            curSum = curSum + nums[right] - nums[left];
            left ++;
            right ++;
            sum[left] = curSum;
        }
        return sum;
    }
}
