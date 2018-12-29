/**
* Binary Tree Level Order Traversal
* Given a binary tree, return the level order traversal of its nodes' values
* Time complexityL: O(N)
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode curNode = queue.poll();
                layer.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                     queue.offer(curNode.right);
                }
            }
            result.add(layer);
        }
        return result;
    }
}
