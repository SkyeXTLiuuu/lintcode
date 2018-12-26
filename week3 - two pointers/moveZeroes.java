/**
* Move Zeroes
* Move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* Time complexity: O(n)
*/

public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return ;
        }
        int zero = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                nums[zero] = nums[i];
                zero ++;
            }
        }
        for (int i = zero; i < nums.length; i ++) {
            nums[i] = 0;
        }
    }
}
