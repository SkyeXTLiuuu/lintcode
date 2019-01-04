/**
* Kth Smallest Element in a BST
* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
* 用 stack，从第一个点开始，走 k-1 步，就是第 k 个点了
* 时间复杂度是 O(h + k)O(h+k) h 是树的高度。
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
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            k --;
            if (k == 0) {
                return curNode.val;
            }
            if (curNode.right != null) {
                curNode = curNode.right;
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            }

        }
        return -1;
    }
}
