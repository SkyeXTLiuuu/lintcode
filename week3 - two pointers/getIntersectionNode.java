/**
* Intersection of Two Linked Lists
* Write a program to find the node at which the intersection of two singly linked lists begins.
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tail = headA;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = headB;
        return detectCycle(headA);
    }

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
