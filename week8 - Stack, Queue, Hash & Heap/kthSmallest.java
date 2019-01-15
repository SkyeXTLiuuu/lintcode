/**
* Kth Smallest Number in Sorted Matrix
* Find the kth smallest number in a row and column sorted matrix
* Priority Queue
* Time complexity: O(k log n)
*/

class Pair {
    int val;
    int row;
    int col;

    public Pair (int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
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

        int[] directionX = {0, 1};
        int[] directionY = {1, 0};
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];

        Comparator<Pair> pairComparator = new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.val - p2.val;
            }
        };

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(pairComparator);
        pq.offer(new Pair(matrix[0][0], 0, 0));

        for (int i = 0; i < k - 1; i ++) {
            Pair cur = pq.poll();

            for (int j = 0; j < 2; j ++) {
                int nextX = cur.row + directionX[j];
                int nextY = cur.col + directionY[j];
                if (nextX < row && nextY < col && !visited[nextX][nextY]) {
                    Pair next = new Pair(matrix[nextX][nextY], nextX, nextY);
                    visited[nextX][nextY] = true;
                    pq.offer(next);
                }
            }
        }

        return pq.peek().val;
    }
}
