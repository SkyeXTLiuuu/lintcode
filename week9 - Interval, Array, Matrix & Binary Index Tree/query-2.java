/**
* Segment Tree Query
* find the maximum number in the interval [start, end] by the given root of segment tree.
* Time complexity:
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
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root.start == start && root.end == end) {
            return root.max;
        }

        int mid = (root.start + root.end) / 2;
        int leftmax = Integer.MIN_VALUE, rightmax = Integer.MIN_VALUE;
        if (start <= mid) {
            if (mid < end) {
                leftmax = query(root.left, start, mid);
            }
            else {
                leftmax = query(root.left, start, end);
            }
        }
        if (mid < end) {
            if (start <= mid) {
                rightmax = query(root.right, mid + 1, end);
            }
            else {
                rightmax = query(root.right, start, end);
            }
        }
        return Math.max(leftmax, rightmax);
    }
}
