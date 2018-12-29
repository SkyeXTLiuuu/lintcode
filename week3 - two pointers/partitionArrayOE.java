/**
* Partition Array by Odd and Even
* Partition an integers array into odd number first and even number second.
* Time complexity: O(n)
*/

public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return ;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left ++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right --;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
    }

    public void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}
