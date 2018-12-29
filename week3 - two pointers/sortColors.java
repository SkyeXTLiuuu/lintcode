/**
* Sort Colors
* Given an array with n objects colored red, white or blue,
* sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
* Time complexity: O(n)
*/

public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
         if(nums == null || nums.length == 0){
            return ;
        }
        int left = 0;
        int index = 0;
        int right = nums.length - 1;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index, left);
                left ++;
                index ++;
            }
            else if (nums[index] == 2) {
                swap(nums, index, right);
                right --;
            }
            else {
                index ++;
            }
        }
    }

    public void swap(int[] A, int left, int right){
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}
