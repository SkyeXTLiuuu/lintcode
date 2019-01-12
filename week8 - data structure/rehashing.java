/**
* Rehash a hash table by doubling the size  
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        ListNode[] newTable = new ListNode[hashTable.length * 2];
        System.out.println(newTable.length);
        System.out.println(hashTable.length);
        for (int i = 0; i < hashTable.length; i ++) {
            if (hashTable[i] == null) {
                continue;
            }
            ListNode node = hashTable[i];
            while (node != null) {
                addValue(node, newTable);
                node = node.next;
            }
        }
        return newTable;
    }

    public void addValue(ListNode node, ListNode[] newTable) {
        int size = newTable.length;
        int hashCode = (node.val % size +size) % size;
        if (newTable[hashCode] == null) {
            newTable[hashCode] = new ListNode(node.val);
        }
        else {
             ListNode dummy = newTable[hashCode];
            while (dummy.next != null) {
                dummy = dummy.next;
            }
            dummy.next = new ListNode(node.val);
        }
    }
};
