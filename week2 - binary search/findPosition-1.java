/**
* Classical Binary Search
* Find any position of a target number in a sorted array. Return -1 if target does not exist.
* Time complexity: O(logn)
* Recursion 
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        if (start > end) {
            return -1;
        }
        int mid = (end - start) / 2 + start;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        }
        return binarySearch(nums, mid + 1, end, target);
    }
}
