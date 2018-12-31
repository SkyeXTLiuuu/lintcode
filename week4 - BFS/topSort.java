/**
* Topological Sorting
* Find any topological order for the given graph.
* Time complexity: O(|V| + |E|)
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();

        // count the indegree of each node
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode n: node.neighbors) {
                    if (!map.containsKey(n)) {
                        map.put(n, 1);
                    }
                    else {
                        map.put(n, map.get(n) + 1);
                    }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        // add nodes with 0 indegree to the queue first
        for (DirectedGraphNode node: graph) {
            if (!map.containsKey(node)) {
                result.add(node);
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode curNode = queue.poll();
            for (DirectedGraphNode n: curNode.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    queue.offer(n);
                }
            }
        }

        return result;
    }
}
