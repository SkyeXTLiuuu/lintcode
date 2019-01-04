/**
* Closest Binary Search Tree Value
* Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    double min_diff = Double.MAX_VALUE;
    TreeNode min_node = null;
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root == null) {
            return -1;
        }
        helper(root, target);
        return min_node.val;
    }

    public void helper(TreeNode root, double target) {
        if (root == null) {
            return ;
        }
        if (Math.abs(root.val - target) < min_diff) {
            min_diff = Math.abs(root.val - target);
            min_node = root;
        }
        if (root.val > target) {
            helper(root.left, target);
        }
        if (root.val < target) {
            helper(root.right, target);
        }
    }
}
