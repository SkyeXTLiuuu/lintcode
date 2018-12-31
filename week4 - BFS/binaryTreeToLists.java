/**
* Convert Binary Tree to Linked Lists by Depth
* Creates a linked list of all the nodes at each depth
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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode position = dummy;
            for(int i = 0; i < size; i ++) {
               TreeNode curNode = queue.poll();
               position.next = new ListNode(curNode.val);
               position = position.next;
               if (curNode.left != null) {
                   queue.offer(curNode.left);
               }
               if (curNode.right != null) {
                   queue.offer(curNode.right);
               }
            }
            result.add(dummy.next);
        }
        return result;
    }
}
