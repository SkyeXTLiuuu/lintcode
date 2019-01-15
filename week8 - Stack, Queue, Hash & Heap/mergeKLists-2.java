/**
* Merge K Sorted Lists
* Merge k sorted linked lists and return it as one sorted list.
* Merge two lists in tree structure 先按照两两分 merge 然后变为n/2个node 再两两分 直到里面只剩下一个元素
* Time complexity: O(nlogk) 树的高度是log k 每个数字参与了log k次排序。在每次排序中，数字贡献O(1)的时间复杂度
* e.g. 排序长度为m和n的数组会用O(m + n) 所以时间复杂度一共是 O(nlogk)
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

       while (lists.size() > 1) {
           List<ListNode> new_lists = new ArrayList<>();
           for (int i = 0; i + 1 < lists.size(); i += 2) {
               ListNode merged_list = merge(lists.get(i), lists.get(i + 1));
               new_lists.add(merged_list);
           }
           if (lists.size() % 2 == 1) {
               new_lists.add(lists.get(lists.size() - 1));
           }
           lists = new_lists;
       }
       return lists.get(0);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            }
            else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null) {
            tail.next = a;
        }
        else {
            tail.next = b;
        }
        return dummy.next;
    }
}
