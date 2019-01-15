/**
* Kth Smallest Number in Sorted Matrix
* Find the kth smallest number in a row and column sorted matrix
* Binary Search
* Time complexity: O(k log n)
*/

class Element {
    int val;
    boolean exist;

    public Element(int val, boolean exist) {
        this.val = val;
        this.exist = exist;
    }
}

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k < 1) {
            return -1;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            Element cur = check(mid, matrix);
            if (cur.exist && cur.val == k) {
                return mid;
            }
            else if (cur.val < k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

    public Element check(int mid, int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int num = 0;
        int i = row - 1;
        int j = 0;
        boolean exist = false;

        while (i >= 0 && j < col) {
            if (matrix[i][j] == mid) {
                exist = true;
            }
            if (matrix[i][j] <= mid) {
                j = j + 1;
                num = num + i + 1;
            }
            else {
                i = i - 1;
            }
        }
        return new Element(num, exist);
    }
}
