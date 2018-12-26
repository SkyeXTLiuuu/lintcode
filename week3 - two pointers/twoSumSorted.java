/**
* Two Sum II - Input array is sorted
* Find two numbers such that they add up to a specific target number in a sorted array
* Time complexity: O(n)
*/

public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum > target) {
                right --;
            }
            else {
                left ++;
            }
        }
        return new int[0];
    }
}
