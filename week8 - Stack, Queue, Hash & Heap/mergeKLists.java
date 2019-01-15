/**
* Merge K Sorted Lists
* Merge k sorted linked lists and return it as one sorted list.
* Priority Queue
* Time complexity: O(nlogk) n is the number of all nodes in lists, because the for loop iterates n times
* logk is get from the priority queue (add an element and place it in the right position)
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
 */
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);

        // 把list里每一位的第一个数加进去
        for (int i = 0; i < lists.size(); i ++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            // 把最小的跳出来并且删除
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummy.next;
    }

    public Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
}
