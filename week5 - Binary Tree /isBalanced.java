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
     * @return: True if this Binary tree is Balanced, or false.
     */

    private int NOT_BALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return maxDepth(root) != NOT_BALANCED;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 要后加1 不然要是在这里加的话 就不可能有left或者right == -1 的情况了
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == NOT_BALANCED || right == NOT_BALANCED) {
            return NOT_BALANCED;
        }
        if (Math.abs(left - right) > 1) {
            return NOT_BALANCED;
        }
        return Math.max(left, right) + 1;
    }
}
