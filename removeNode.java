/**
* Remove Node in Binary Search Tree
* Given a root of Binary Search Tree with unique value for each node.
* Remove the node with given value.
* If there is no such a node with given value in the binary search tree, do nothing.
* You should keep the tree still a binary search tree after removal.
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
    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    TreeNode parent = null;
    TreeNode successorParent = null;
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }
        TreeNode target = searchForTarget(root, value);
        if (target == null) {
            return root;
        }

        // if the node has no children
        if (target.left == null && target.right == null) {
            // the root => empty tree
            if (parent == target) {
                return null;
            }

            if (parent.left == target) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }

        // if the node has one children
        else if (target.left == null || target.right == null) {
            if (parent == target) {
                if (parent.left != null) {
                    return parent.left;
                }
                else {
                    return parent.right;
                }
            }

            if (target.left != null) {
                if (parent.left == target) {
                    parent.left = target.left;
                }
                else {
                    parent.right = target.left;
                }
            }
            else {
                if (parent.left == target) {
                    parent.left = target.right;
                }
                else {
                    parent.right = target.right;
                }
            }
        }

        // if the node has two children
        else {
            TreeNode successor = getSuccessor(target);
            swap(target, successor);
            if (successorParent.left == successor) {
                successorParent.left = null;
            }
            else {
                successorParent.right = null;
            }
        }
        return root;
    }

    private TreeNode getSuccessor(TreeNode target) {
        successorParent = target;
        target = target.right;
        while (target.left != null) {
            successorParent = target;
            target = target.left;
        }
        return target;
    }

    private void swap(TreeNode target, TreeNode successor) {
        int tmp = target.val;
        target.val = successor.val;
        successor.val = tmp;
    }

    private TreeNode searchForTarget(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        parent = root;
        while (root != null) {
            if (root.val == value) {
                return root;
            }
            if (root.val > value) {
                parent = root;
                root = root.left;
            }
            else {
                parent = root;
                root = root.right;
            }
        }
        return null;
    }
}
