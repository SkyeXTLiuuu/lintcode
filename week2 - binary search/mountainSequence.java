/**
* Maximum Number in Mountain Sequence
* Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
* Time complexity: O(logn) 
*/

public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return Math.max(nums[start], nums[end]);
    }
}
