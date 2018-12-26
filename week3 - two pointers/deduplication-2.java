/**
* Remove Duplicate Numbers in Array
* Given an array of integers, remove the duplicate numbers in it.
* Time complexity: O(n)
* Space complexity: O(n)
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
        Set<Integer> unique = new HashSet<Integer>();
        int position = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (!unique.contains(nums[i])) {
                nums[position] = nums[i];
                unique.add(nums[i]);
                position ++;
            }
        }
        return position;
    }
}
