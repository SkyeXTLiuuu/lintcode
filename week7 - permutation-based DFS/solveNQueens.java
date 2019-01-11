/**
* N-Queens
* Place n queens on an n×n chessboard such that no two queens attack each other.
* Time complexity: O(n!) ?
* iteration
*/

public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (n < 1) {
            return results;
        }
        List<Integer> solution = new ArrayList<>();
        dfs(n, 0, solution, results);
        return results;
    }

    public void dfs(int n, int index, List<Integer> solution, List<List<String>> results) {
        if (index == n) {
            List<String> list = convertToString(solution, n);
            results.add(list);
            return ;
        }

        for (int i = 0; i < n; i ++) {
            if (!isSafe(solution, i)) {
                continue;
            }
            solution.add(i);
            dfs(n, index + 1, solution, results);
            solution.remove(solution.size() - 1);
        }
    }

    // public void printSolution(List<Integer> solution) {
    //     for (int i = 0; i < solution.size(); i ++) {
    //         System.out.print(solution.get(i));
    //         System.out.print(",");
    //     }
    //     System.out.println();
    // }

    public boolean isSafe(List<Integer> solution, int position) {
        int row = solution.size();
        for (int i = 0; i < solution.size(); i ++) {
            if (solution.get(i) == position) {
                return false;
            }
            if (i + solution.get(i) == row + position) {
                return false;
            }
            if (i - solution.get(i) == row - position) {
                return false;
            }
        }
        return true;
    }

    public List<String> convertToString(List<Integer> solution, int n) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            StringBuilder sb = new StringBuilder();
            int queen = solution.get(i);
            for (int j = 0; j < n; j ++) {
                if (j == queen) {
                    sb.append("Q");
                }
                else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}
