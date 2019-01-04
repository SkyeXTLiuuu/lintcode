/**
* Construct Binary Tree from Preorder and Inorder Traversal
* Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    public int getIndex(int[] inorder, int start, int end, int target) {
        for (int i = start; i <= end; i ++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode helper(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }
        // the last number in the postorder array is the root
        TreeNode root = new TreeNode(preorder[prestart]);
        // find the position of the root in the inorder array
        // things before the index is in the left
        // things after the index is in the right
        int position = getIndex(inorder, instart, inend, preorder[prestart]);
        TreeNode left = helper(inorder, instart, position - 1, preorder, prestart + 1, prestart + position - instart);
        TreeNode right = helper(inorder, position + 1, inend, preorder, position - inend + preend + 1, preend);
        root.left = left;
        root.right = right;
        return root;
    }
}
