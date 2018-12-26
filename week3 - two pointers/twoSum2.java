/**
* Two Sum - Greater than target
* Find how many pairs in the array such that their sum is bigger than a specific target number
* Time complexity: O(nlogn)
*/

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                left ++;
            }
            else {
                count = count + (right - left);
                right --;
            }
        }
        return count;
    }
}
