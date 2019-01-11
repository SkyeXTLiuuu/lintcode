/**
* Combination Sum II
* Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
* Time complexity: ?
* DFS
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }
        Arrays.sort(num);
        dfs(num, 0, new ArrayList<Integer>(), target, results);
        return results;
    }

    public void dfs(int[] num,
                    int index,
                    List<Integer> result,
                    int target,
                    List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(result));
            return ;
        }

        for (int i = index; i < num.length; i ++) {
            if (i != index && num[i] == num[i - 1]) {
                continue;
            }
            if (target < num[i]) {
                break;
            }
            result.add(num[i]);
            dfs(num, i + 1, result, target - num[i], results);
            result.remove(result.size() - 1);
        }
    }
}
