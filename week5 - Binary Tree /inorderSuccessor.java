/**
* Inorder Successor in BST
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 *
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) {
            return null;
        }
        TreeNode successor = null;
        // search for the node
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        // no such node
        if (root == null) {
            return null;
        }

        // the successor of the node is on the top of it
        if (root.right == null) {
            return successor;
        }

        // the successor of the node is below it 
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
