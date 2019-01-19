/**
* Segment Tree Query II
* Find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.
* binary segment tree
* Time complexity:
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start > end || root == null) {
            return 0;
        }

        if (start <= root.start && end >= root.end) {
            return root.count;
        }

        int mid = (root.start + root.end) / 2;
        int leftCount = 0, rightCount = 0;
        if (start <= mid) {
            if (end > mid) {
                leftCount = query(root.left, start, mid);
            }
            else {
                leftCount = query(root.left, start, end);
            }
        }

        if (end > mid) {
            if (start <= mid) {
                rightCount = query(root.right, mid + 1, end);
            }
            else {
                rightCount = query(root.right, start, end);
            }
        }

        return leftCount + rightCount;
    }
}
