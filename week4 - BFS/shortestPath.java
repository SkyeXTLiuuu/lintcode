/**
* Knight Shortest Path
* Find the shortest path to a destination position
* Time complexity:
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    int[] directionX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] directionY = {2, -2, 1, -1, 2, -2, 1, -1};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int step = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step ++;
            for (int a = 0; a < size; a ++) {
                Point curPoint = queue.poll();
                for (int i = 0; i < directionX.length; i ++) {
                    Point p = new Point(curPoint.x + directionX[i], curPoint.y + directionY[i]);
                    if (!inRange(grid, p)) {
                        continue;
                    }
                    if (p.x == destination.x && p.y == destination.y) {
                        return step;
                    }
                    queue.offer(p);
                    grid[p.x][p.y] = true;
                }
            }
        }
        return -1;
    }

    public boolean inRange(boolean[][] grid, Point point) {
        if (point.x < 0 || point.x >= grid.length) {
            return false;
        }
        if (point.y < 0 || point.y >= grid[0].length) {
            return false;
        }
        return (grid[point.x][point.y] == false);
    }
}
