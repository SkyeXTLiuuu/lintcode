/**
* Two Sum - Closest to target
* Find two integers in nums such that the sum is closest to a given number, target.
* Time complexity: O(nlogn)
*/

public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (left < right) {
            diff = Math.min(diff, Math.abs(nums[left] + nums[right] - target));
            if (nums[left] + nums[right] == target) {
                return 0;
            }
            if (nums[left] + nums[right] > target) {
                right --;

            }
            else {
                left ++;
            }
        }
        return diff;
    }
}
