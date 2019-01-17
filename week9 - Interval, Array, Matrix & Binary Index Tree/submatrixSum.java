/**
* Submatrix Sum
* Given an integer matrix, find a submatrix where the sum of numbers is zero.
* Your code should return the coordinate of the left-up and right-down number.
* dynamic programming
* Time complexity:
*/

public class Solution {
    /*
     * @param matrix: an integer matrix
     * @return: the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[2][2];
        }

        int[][] result = new int[2][2];
        int M = matrix.length;
        int N = matrix[0].length;

        // sum[i][j] = sum of submatrix[(0, 0), (i, j)]
        // 先对矩阵matrix的每个点到左顶点之间的子矩阵求和，存在新矩阵sum上
        int[][] sum = new int[M + 1][N + 1];
        for (int j = 0; j <= N; j ++) {
            sum[0][j] = 0;
        }
        for (int i = 1; i <= M; i ++) {
            sum[i][0] = 0;
        }
        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j ++) {
                sum[i + 1][j + 1] = matrix[i][j] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
            }
        }

        // 从0开始，确定两行i1、i2，再将第k列的sum[i1][k]和sum[i2][k]相减
        // 就得到matrix[i1][0]到matrix[i2][k-1]的子矩阵（i2-i1行，k列）求和diff
        for (int l = 0; l < M; l ++) {
            for (int h = l + 1; h <= M; h ++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j <= N; j ++) {
                    int diff = sum[h][j] - sum[l][j];
                    // 假设计算到第j列，得到了相等的和diff。
                    // 说明从i1到i2行，从k到j列的子矩阵求和为0，即相当于两个平行放置的矩形，
                    // 若左边的值为diff，左边与右边之和也是diff，那么右边的值一定为0。
                    if (map.containsKey(diff)) {
                        int k = map.get(diff);
                        result[0][0] = l; // l + 1 - 1
                        result[0][1] = k; // k + 1 - 1
                        result[1][0] = h - 1;
                        result[1][1] = j - 1;
                        return result;
                    }
                    else {
                        map.put(diff, j);
                    }
                }
            }
        }
        return result;
    }
}
