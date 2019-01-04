/**
* Subtree with Maximum Average
* Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
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
class ResultType{
    int num;
    int sum;
    public ResultType(int num, int sum) {
        this.num = num;
        this.sum = sum;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    ResultType subtree_result = null;
    TreeNode subtree = null;
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        helper(root);
        return subtree;
    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType node = new ResultType(left.num + 1 + right.num, left.sum + right.sum + root.val);
        if (subtree == null || subtree_result.sum * node.num < subtree_result.num * node.sum) {
            subtree = root;
            subtree_result = node;
        }
        return node;
    }
}
