/**
* Next Permutation II 
* Rearrange numbers into the lexicographically next greater permutation of numbers.
*/

public class Solution {
    /**
     * @param nums: An array of integers
     * @return: nothing
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return ;
        }
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i --) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        // if the current order is the largest possible order
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return ;
        }
        // find the point to switch
        int nextBigger = index + 1;
        for (int i = nums.length - 1; i > index; i --) {
            if (nums[i] > nums[index]) {
                nextBigger = i;
                break;
            }
        }
        swap(nums, index, nextBigger);
        reverse(nums, index + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }

    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
