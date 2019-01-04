/**
* Flatten Binary Tree to Linked List
* Flatten a binary tree to a fake "linked list" in pre-order traversal.
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return ;
        }
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (right != null) {
            return right;
        }
        if (left != null) {
            return left;
        }
        return root;
    }
}
