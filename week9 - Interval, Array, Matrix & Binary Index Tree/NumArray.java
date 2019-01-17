/**
* Range Sum Query - Immutable
* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
* example: Given nums = [-2, 0, 3, -5, 2, -1] => sumRange(0, 2) -> 1
* Time complexity:
*/

class NumArray {

    int[] prefix;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            prefix = new int[0];
        }

        prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i ++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j >= prefix.length || i > j) {
            return -1;
        }

        return prefix[j + 1] - prefix[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
