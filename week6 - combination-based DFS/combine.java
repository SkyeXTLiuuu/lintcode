/**
* Combinations
* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
* Time complexity:
* DFS
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();

        // start from 1
        helper(rst, solution, n, k, 1);
        return rst;
    }

    private void helper(List<List<Integer>> rst, List<Integer> solution,
        int n, int k, int start) {
        if (solution.size() == k){
            rst.add(new ArrayList(solution));
            return;
        }

        for(int i = start; i<= n; i++){
            solution.add(i);

            // the new start should be after the next number after i
            helper(rst, solution, n, k, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}
