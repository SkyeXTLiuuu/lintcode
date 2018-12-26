/**
* Remove Duplicate Numbers in Array
* Given an array of integers, remove the duplicate numbers in it.
* Time complexity: O(nlogn)
* Space complexity: O(1)
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        Arrays.sort(nums);
        while (fast < nums.length) {
            while (fast < nums.length - 1 && nums[fast] == nums[fast + 1]){
                fast ++;
            }
            nums[slow] = nums[fast];
            slow ++;
            fast ++;
        }
        return slow;
    }
}
