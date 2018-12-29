/**
* Kth Smallest Numbers in Unsorted Array
* Find the kth smallest number in an unsorted integer array.
* Time complexity: O(n)
* Space complexity: O(1)
* Quick Select
*/

public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
                // write your code her
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[k];
        }
        int pivot = nums[(start + end) / 2];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left ++;
            }
            while (left <= right && nums[right] > pivot) {
                right --;
            }
            if (left <= right) {
                swap(nums, left, right);
                left ++;
                right --;
            }
        }
        if (k <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (k >= left) {
            return quickSelect(nums, left, end, k);
        }
        return nums[k];
    }

    public void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}
