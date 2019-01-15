/**
* Top k Largest Numbers
* Given an integer array, find the top k largest numbers in it.
* Quick Sort
* Time complexity: O(nlogn)
*/

public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here

        if (nums == null || nums.length == 0 || k < 1) {
            return new int[0];
        }

        quickSort(nums, 0, nums.length - 1);

        int[] result = new int[k];
        for (int i = 0; i < k; i ++) {
            result[i] = nums[i];
        }
        return result;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return ;
        }

        int index = (int) Math.random() * (end - start) + start;
        int pivot = nums[index];

        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left ++;
            }
            while (left <= right && nums[right] < pivot) {
                right --;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;

                left ++;
                right --;
            }
        }

        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}
