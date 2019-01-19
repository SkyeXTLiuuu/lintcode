/**
* Segment Tree Modify
* For a Maximum Segment Tree, which each node has an extra value max to store the maximum value in this node's interval.
* Implement a modify function with three parameter root, index and value to change the node's value
* Time complexity: O(logN)
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: nothing
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root == null) {
            return ;
        }
        // 找到需要更改的点
        if (root.start == root.end && root.start == index) {
            root.max = value;
            return ;
        }

        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            modify(root.left, index, value);
            // 检查他一路上的parent的值要不要更改
            root.max = Math.max(root.left.max, root.right.max);
        }
        else {
            modify(root.right, index, value);
            // 检查他一路上的parent的值要不要更改
            root.max = Math.max(root.left.max, root.right.max);
        }
    }
}
