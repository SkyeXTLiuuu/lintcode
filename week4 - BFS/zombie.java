/**
* Zombie in Matrix
* How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.
* Time complexity:
*/

class Coordinate{
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */

    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;

    public int[] deltaX = {1, 0, 0, -1};
    public int[] deltaY = {0, 1, -1, 0};

    public int zombie(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int people = 0;
        int days = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == PEOPLE) {
                    people ++;
                }
                if (grid[i][j] == ZOMBIE) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        if (people == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            days ++;
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                Coordinate zb = queue.poll();
                for (int direction = 0; direction < 4; direction ++) {
                    Coordinate adj = new Coordinate(zb.x + deltaX[direction], zb.y + deltaY[direction]);
                    if (!isPeople(adj, grid)) {
                        continue;
                    }
                    grid[adj.x][adj.y] = ZOMBIE;
                    people --;
                    if (people == 0) {
                        return days;
                    }
                    queue.offer(adj);
                }
            }
        }
        return -1;
    }

    private boolean isPeople(Coordinate coor, int[][] grid) {
        if (coor.x < 0 || coor.x >= grid.length) {
            return false;
        }
        if (coor.y < 0 || coor.y >= grid[0].length) {
            return false;
        }
        return (grid[coor.x][coor.y] == PEOPLE);
    }
}
