/**
* Two Sum - Unique pairs
* Find how many unique pairs in the array such that their sum is equal to a specific target number. 
* Time complexity: O(n)
*/

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                count ++;
                while (left < right && nums[left + 1] == nums[left]) {
                    left ++;
                }
                while (left < right && nums[right - 1] == nums[right]) {
                    right --;
                }
            }
            if (nums[left] + nums[right] > target) {
                right --;
            }
            else {
                left ++;
            }
        }
        return count;
    }
}
