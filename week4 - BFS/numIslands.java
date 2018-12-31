/**
* Number of Islands
* Find the number of islands.
* Time complexity: O(N)
*/

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */

    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (grid[i][j] == true) {
                    count ++;
                    markIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    public void markIsland(boolean[][] grid, int i, int j) {
        if (!inrange(grid, i, j)) {
            return ;
        }
        if (grid[i][j] == true) {
            grid[i][j] = false;
            markIsland(grid, i + 1, j);
            markIsland(grid, i - 1, j);
            markIsland(grid, i, j + 1);
            markIsland(grid, i, j - 1);
        }
    }

    public boolean inrange(boolean[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }
}
