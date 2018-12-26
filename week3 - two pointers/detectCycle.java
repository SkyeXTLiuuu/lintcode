/**
* Linked List Cycle II
* Given a linked list, return the node where the cycle begins.
* Time complexity: O(n)
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return getIntersect(head, slow);
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }

    public ListNode getIntersect(ListNode head, ListNode node) {
        ListNode slow = head;
        while (slow != node.next) {
            slow = slow.next;
            node = node.next;
        }
        return slow;
    }
}
