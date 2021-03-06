/**
* Permutations
* Given a list of numbers, return all possible permutations.
* Time complexity: O(n!)
*/

public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);
        return results;
    }

    public void dfs(int[] nums,
                    boolean[] visited,
                    List<Integer> permutation,
                    List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
            return ;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
