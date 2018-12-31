/**
* Search Graph Nodes
* Return the nearest node to given node which value of it is target, return NULL if you can't find.
* Time complexity:
*/

/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // write your code here
        if (graph == null || graph.size() == 0) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (values.get(cur) == target) {
                return cur;
            }

            for (UndirectedGraphNode neigh: cur.neighbors) {
                if (!set.contains(neigh)) {
                     queue.offer(neigh);
                    set.add(neigh);
                }
            }
        }
        return null;
    }
}
