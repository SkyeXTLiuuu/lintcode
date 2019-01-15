/**
* Copy List with Random Pointer
* HashMap - my solution 
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            if (!map.containsKey(cur)) {
                map.put(cur, new RandomListNode(cur.label));
            }
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode curNode = map.get(cur);
            curNode.next = map.get(cur.next);
            curNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
