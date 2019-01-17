/**
* Sparse Matrix Multiplication
* Given two Sparse Matrix A and B, return the result of AB.
* Improved version 
* Time complexity:
*/

public class Solution {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        if (A == null || B == null) {
            return null;
        }

        List<List<Integer>> col = new ArrayList<>();
        int[][] result = new int[A.length][B[0].length];

        for (int i = 0; i < A[0].length; i ++) {
            col.add(new ArrayList<>());
            for (int j = 0; j < B[0].length; j ++) {
                if (B[i][j] != 0) {
                    col.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < A.length; i ++) {
             for (int k = 0; k < A[0].length; k ++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j: col.get(k)) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }
}
