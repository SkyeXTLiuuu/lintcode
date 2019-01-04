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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path: leftPaths){
            result.add(root.val + "->" + path);
        }
        for (String path: rightPaths){
            result.add(root.val + "->" + path);
        }
        // root is a leaf
        if (result.size() == 0) {
            result.add("" + root.val);
        }
        return result;
    }
}
