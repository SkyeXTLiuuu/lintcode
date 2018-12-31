/**
* Clone Graph
* Clone an undirected graph
* Time complexity: O(|V| + |E|)
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        for (UndirectedGraphNode n: nodes){
            UndirectedGraphNode curNode = mapping.get(n);
            for (UndirectedGraphNode oldN: n.neighbors) {
                UndirectedGraphNode neighbor = mapping.get(oldN);
                curNode.neighbors.add(neighbor);
            }
        }

        return mapping.get(node);
    }

    public ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            for (UndirectedGraphNode neighbor: curNode.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode> (set);
    }
}
