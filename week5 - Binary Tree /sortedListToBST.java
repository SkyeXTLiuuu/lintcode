/**
* Convert Sorted List to Binary Search Tree
* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        int size = getListLength(head);
        current = head;
        return helper(size);
    }

    public TreeNode helper(int size) {
        if (size <= 0) {
            return null;
        }
        TreeNode left = helper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helper(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
    }

    public int getListLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
}
