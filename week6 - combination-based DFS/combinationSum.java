/**
* Combination Sum
* Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
* Time complexity: O(2 ^ n) 一共这么多可能的结果
* DFS
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        int[] nums = removeDuplicates(candidates);
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        helper(nums, target, 0, new ArrayList<Integer>(), results);
        return results;
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);

        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }

        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }

        return nums;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> result, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(result));
            return ;
        }

        for (int i = index; i < candidates.length; i ++)     {
           if (target < candidates[i]) {
                break;
            }
            result.add(candidates[i]);
            helper(candidates, target - candidates[i], i, result, results);
            result.remove(result.size() - 1);
        }
    }
}
