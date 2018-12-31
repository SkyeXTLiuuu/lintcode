/**
* Connected Component in Undirected Graph
* Find the number connected component in the undirected graph.
* Time complexity:
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        if (nodes == null || nodes.size() == 0) {
            return null;
        }

        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        for (UndirectedGraphNode node: nodes) {
           visited.put(node, false);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (UndirectedGraphNode node: nodes) {
            if (visited.get(node) == false) {
               bfs(node, visited, result);
            }
        }
        return result;
    }

    public void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> result) {
        List<Integer> component = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        visited.put(node, true);
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            component.add(cur.label);
            for (UndirectedGraphNode neigh: cur.neighbors) {
                if (visited.get(neigh) == false) {
                    queue.add(neigh);
                    visited.put(neigh, true);
                }
            }
        }
        Collections.sort(component);
        result.add(component);
    }
}
