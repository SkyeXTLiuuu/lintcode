/**
* Maximum Depth of Binary Tree
* Given a binary tree, find its maximum depth.
* Time complexity: O(n)
* Recursion
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
     * @return: An integer
     */
    int depth = 0;
    public int maxDepth(TreeNode root) {
        // write your code here
        int curDepth = 1;
        helper(root, curDepth);
        return depth;
    }

    public void helper(TreeNode root, int curDepth) {
        if (root == null) {
            return ;
        }
        if (curDepth > depth) {
            depth = curDepth;
        }
        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);
    }
}
