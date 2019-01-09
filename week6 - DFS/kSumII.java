/**
* k Sum II
* Given n unique integers, number k (1<=k<=n) and target.
* Time complexity: ?
* DFS
*/

public class Solution {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (A == null || A.length == 0 || k < 1) {
            return results;
        }
        Arrays.sort(A);
        dfs(A, k, 0, new ArrayList<Integer>(), target, results);
        return results;
    }

    public void dfs(int[] A, int k, int index, List<Integer> result, int target, List<List<Integer>> results) {
        if (k < 0) {
            return ;
        }
        if (k == 0 && target == 0) {
            results.add(new ArrayList<Integer>(result));
            return ;
        }
        for (int i = index; i < A.length; i ++) {
            if (target < A[i]) {
                continue;
            }
            result.add(A[i]);
            dfs(A, k - 1, i + 1, result, target - A[i], results);
            result.remove(result.size() - 1);
        }
    }
}
