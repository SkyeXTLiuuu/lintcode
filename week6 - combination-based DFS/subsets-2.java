/**
* Subsets
* Given a set of distinct integers, return all possible subsets.
* Time complexity: O(2 ^ n) 一共这么多可能的结果
* DFS 可以拓展到全排列的模版
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
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    public void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {

        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        result.add(new ArrayList<Integer>(subset));

        for (int i = index; i < nums.length; i ++) {
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(nums, i + 1, result, subset);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }

        // 3. 递归的出口
        // return ;
    }
}
