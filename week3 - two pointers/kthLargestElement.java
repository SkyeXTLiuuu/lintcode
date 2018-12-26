/**
* Kth Largest Element
* Find K-th largest element in an array.
* Time complexity: O(n)
* Space complexity: O(1)
* Quick Select
*/

public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || n > nums.length) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - n);
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
