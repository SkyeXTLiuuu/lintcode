/**
* Two Sum - Less than or equal to target
* Find how many pairs in the array such that their sum is less than or equal to a specific target number
* Time complexity: O(nlogn)
*/

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right --;
            }
            else {
                count = count + (right - left);
                left ++;
            }
        }
        return count;
    }
}
