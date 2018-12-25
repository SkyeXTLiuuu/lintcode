/**
* Recover Rotated Sorted Array
* Given a rotated sorted array, recover it to sorted array in-place.
* example: [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
* 三步翻转法
* Time complexity: O(n)
*/

public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return ;
        }
       for (int i = 0; i < nums.size() - 1; i ++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
            }
        }
    }

    private void reverse(List<Integer> nums, int start, int end){
        if (start >= end || start >= nums.size() || end >= nums.size()) {
            return ;
        }
        while (start < end) {
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start ++;
            end --;
        }
    }
}
