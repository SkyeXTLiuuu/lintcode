/**
* Validate Binary Search Tree
* Given a binary tree, determine if it is a valid binary search tree (BST)
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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        long lowerBound = Long.MIN_VALUE;
        long upperBound = Long.MAX_VALUE;
        return helper(root, lowerBound, upperBound);
    }

    public boolean helper(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) {
            return true;
        }
        if (root.val <= lowerBound || root.val >= upperBound) {
            return false;
        }
        boolean left = helper(root.left, lowerBound, root.val);
        boolean right = helper(root.right, root.val, upperBound);
        return left && right;
    }
}
