/**
* Toeplitz Matrix
* A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
* return True if and only if the matrix is Toeplitz
* example:
*   Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
*   Output: True
*   Explanation:
*       1234
*       5123
*       9512
*
*/

public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0) {
            return true;
        }

        for (int i = 0; i < matrix.length - 1; i ++) {
            for (int j = 0; j < matrix[0].length - 1; j ++) {
                if (matrix[i + 1][j + 1] != matrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
