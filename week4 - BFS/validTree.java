/**
* Graph Valid Tree
* Check whether these edges make up a valid tree.
* Time complexity:
*/

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (edges == null) {
            return true;
        }

        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            map.put(i, new HashSet<>());
        }

        for (int i = 0; i < edges.length; i ++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();

        queue.offer(0);
        hash.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor: map.get(node)) {
                if (hash.contains(neighbor)) {
                    continue;
                }
                hash.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return hash.size() == n;
    }
}
