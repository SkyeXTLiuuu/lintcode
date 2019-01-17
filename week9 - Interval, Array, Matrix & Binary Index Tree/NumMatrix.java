/**
* Range Sum Query 2D - Immutable
* Find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
*/

class NumMatrix {

    int[][] prefix;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            prefix = new int[0][0];
        }

        this.matrix = matrix;
        prefix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                prefix[i + 1][j + 1] = matrix[i][j] + prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0 || row1 > row2 || col1 > col2 || row1 >= matrix.length || row2 >= matrix.length || col1 >= matrix[0].length || col2 >= matrix[0].length) {
        //     return 0;
        // }

        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
