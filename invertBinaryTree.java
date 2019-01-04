/**
* Invert Binary Tree
* Invert a binary tree.
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
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return ;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}
