/**
* Subsets
* Given a set of distinct integers, return all possible subsets.
* Time complexity: O(2 ^ n) 一共这么多可能的结果
* DFS - deep copy first 
*/

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        helper(nums, 0, result, new ArrayList<Integer>());
        return result;
    }

    public void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
        result.add(subset);

        for (int i = index; i < nums.length; i ++) {
            List<Integer> newList = new ArrayList(subset);
            subset.add(nums[i]);
            helper(nums, i + 1, result, newList);
        }
    }
}
