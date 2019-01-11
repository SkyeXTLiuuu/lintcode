/**
* Lowest Common Ancestor III
* Find the lowest common ancestor(LCA) of the two nodes.
* 与之前那个LCA不同的是这两个node不一定存在
* Time complexity:
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
class ResultType {
    public boolean a_exist, b_exist;
    public TreeNode node;
    ResultType(boolean a, boolean b, TreeNode n) {
        a_exist = a;
        b_exist = b;
        node = n;
    }
}

public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType rt = helper(root, A, B);
        if (rt.a_exist && rt.b_exist) {
            return rt.node;
        }
        else {
            return null;
        }
    }

    public ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }
        ResultType left_rt = helper(root.left, A, B);
        ResultType right_rt = helper(root.right, A, B);

        boolean a_exist = left_rt.a_exist || right_rt.a_exist || root == A;
        boolean b_exist = left_rt.b_exist || right_rt.b_exist || root == B;

        if (root == A || root == B) {
            return new ResultType(a_exist, b_exist, root);
        }

        if (left_rt.node != null && right_rt.node != null) {
            return new ResultType(a_exist, b_exist, root);
        }
        if (left_rt.node != null) {
            return new ResultType(a_exist, b_exist, left_rt.node);
        }
        if (right_rt.node != null) {
            return new ResultType(a_exist, b_exist, right_rt.node);
        }
        return new ResultType(a_exist, b_exist, null);
    }
}
