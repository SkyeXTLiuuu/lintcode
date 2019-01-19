/**
* Segment Tree Build II
* Build a segment tree with five properties
* Time complexity: O(N)
* Space complexity: O(N)
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
     * @param A: a list of integer
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        return buildHelper(A, 0, A.length - 1);
    }

    public SegmentTreeNode buildHelper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, start, A[start]);
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end, A[start]);
        int mid = (start + end) / 2;
        SegmentTreeNode left = buildHelper(A, start, mid);
        SegmentTreeNode right = buildHelper(A, mid + 1, end);

        root.left = left;
        root.right = right;

        if (root.left != null) {
            root.max = Math.max(root.max, root.left.max);
        }
        if (root.right != null) {
            root.max = Math.max(root.max, root.right.max);
        }
        return root;
    }
}
