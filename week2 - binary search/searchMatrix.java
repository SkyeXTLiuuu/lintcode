/**
* Search a 2D Matrix
* Write an efficient algorithm that searches for a value in an m x n matrix
* This matrix has the following properties:
*   Integers in each row are sorted from left to right.
*   The first integer of each row is greater than the last integer of the previous row.
* Time complexity: O(logm + logn) 
*/

public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int row = findRow(matrix, target);
        if (matrix[row][0] > target && matrix[row][m] < target) {
            return false;
        }
        int start = 0;
        int end = n;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (matrix[row][mid] == target) {
                return true;
            }
            else if (matrix[row][mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;
    }

    public int findRow(int[][] matrix, int target){
        int start = 0;
        int end = matrix.length - 1;
        int m = matrix[0].length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (matrix[mid][m] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (matrix[start][0] <= target && matrix[start][m] >= target) {
            return start;
        }
        else {
            return end;
        }
    }
}
