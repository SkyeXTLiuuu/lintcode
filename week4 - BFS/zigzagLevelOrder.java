/**
* Binary Tree Zigzag Level Order Traversal
* Return the zigzag level order traversal of its nodes' values
* Time complexity: O(N)
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
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftFirst = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            if (leftFirst) {
                reverse(list);
            }
            result.add(list);
            leftFirst = !leftFirst;
        }

        return result;
    }

    public void reverse(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int tmp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, tmp);
            left ++;
            right --;
        }
    }
}
