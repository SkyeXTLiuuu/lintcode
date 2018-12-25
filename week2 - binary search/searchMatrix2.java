/**
* Search a 2D Matrix II
* Search for a value in an m x n matrix, return the occurrence of it
* This matrix has the following properties:
*   Integers in each row are sorted from left to right.
*   Integers in each column are sorted from up to bottom.
*   No duplicate integers in each row or column.
* Time complexity: O(m + n)
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int startX = 0;
        int startY = col - 1;
        int count = 0;
        while (startX >= 0 && startX < row && startY >= 0 && startY < col) {
            int cur = matrix[startX][startY];
            if (cur == target) {
                count ++;
                startX ++;
                startY --;
            }
            else if (cur > target) {
                startY --;
            }
            else {
                startX ++;
            }
        }
        return count;
    }
}
