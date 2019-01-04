/**
* Minimum Subtree
* Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
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
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    int min = Integer.MAX_VALUE;
    TreeNode min_node = null;
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        helper(root);
        return min_node;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int node = left + right + root.val;
        if (min_node == null || min > node) {
            min = node;
            min_node = root;
        }
        return node;
    }
}
