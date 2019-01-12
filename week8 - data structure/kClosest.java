/**
* K Closest Points
* Given some points and an origin point in two-dimensional space, find k points which are nearest to the origin.
* e.g. Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3 => [[1,1],[2,5],[4,4]]
* Priority Queue
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
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        Point[] results = new Point[k];
        if (points == null || points.length == 0 || points.length < k) {
            return results;
        }
        Queue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                // 头上大的会先被挤出去
                int diff = getDistance(b, origin) - getDistance(a, origin);
                if (diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        });

        for (int i = 0; i < points.length; i ++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        k = pq.size() - 1;
        while (!pq.isEmpty()) {
            results[k] = pq.poll();
            k --;
        }
        return results;
    }

    public int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
