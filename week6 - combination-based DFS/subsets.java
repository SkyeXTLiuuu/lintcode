/**
* Subsets
* Given a set of distinct integers, return all possible subsets.
* Time complexity: O(2 ^ n) 一共这么多可能的结果
* DFS
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

    // 递归三要素
    // 1. 递归的定义
    // 以 subset 开头的，配上 nums 以 index 开始的数所有组合放到results里
    public void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
        // 3. 递归的出口
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(subset));
            return ;
        }

        // 2. 递归的拆解
        // （如何进入下一层）

        // 选了 nums[index]
        subset.add(nums[index]);
        helper(nums, index + 1, result, subset);

        // 没选 nums[index]
        subset.remove(subset.size() - 1);
        helper(nums, index + 1, result, subset);
    }
}
