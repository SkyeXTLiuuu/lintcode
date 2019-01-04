/**
* Construct Binary Tree from Inorder and Postorder Traversal
* Given inorder and postorder traversal of a tree, construct the binary tree.
*
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
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public int getIndex(int[] inorder, int start, int end, int target) {
        for (int i = start; i <= end; i ++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }
        // the last number in the postorder array is the root
        TreeNode root = new TreeNode(postorder[postend]);
        // find the position of the root in the inorder array
        // things before the index is in the left
        // things after the index is in the right 
        int position = getIndex(inorder, instart, inend, postorder[postend]);
        TreeNode left = helper(inorder, instart, position - 1, postorder, poststart, poststart + position - instart - 1);
        TreeNode right = helper(inorder, position + 1, inend, postorder, poststart + position - instart, postend - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
