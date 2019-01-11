/**
* Permutations II
* Given a list of numbers with duplicate number in it. Find all unique permutations.
* Time complexity: O(n!)
*/

public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
         // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        // sort to choose representatives
        Arrays.sort(nums);
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
            // if the number is same as the number before it and the number before it has not been added
            // [1, 3', 3''] 3 '' will be chosen iff 3 ' has been chosen'
            if (i != 0 && nums[i - 1] == nums[i] && visited[i - 1] == false) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
};
