/**
* Interval Sum II
* Given an integer array in the construct method, implement two methods query(start, end) and modify(index, value):
* query(start, end): the sum from index start to index end
* modify(index, value): modify the number in the given index to value
* binary segment tree
* Time complexity:
*/

public class Solution {
    /* you may need to use some attributes here */

    class SegmentTreeNode {
        public int start,end;
        public int sum;
        public SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = this.right = null;
        }
    }

    SegmentTreeNode root;

    public SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);
            root.sum = root.left.sum + root.right.sum;
        }
        // when start = end, i.e. this is not an interval, just a number
        else {
            root.sum = A[start];
        }

        return root;
    }

    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (start == root.start && end == root.end) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        int leftSum = 0, rightSum = 0;

        // 在左边有东西
        if (start <= mid) {
            if (end > mid) {
                leftSum = querySegmentTree(root.left, start, mid);
            }
            else {
                leftSum = querySegmentTree(root.left, start, end);
            }
        }

        if (end > mid) {
            if (start <= mid) {
                rightSum = querySegmentTree(root.right, mid + 1, end);
            }
            else {
                rightSum = querySegmentTree(root.right, start, end);
            }
        }

        return leftSum + rightSum;
    }

    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        // find the element of index index
        if (root.start == index && root.end == index) {
            root.sum = value;
            return ;
        }

        int mid = (root.start + root.end) / 2;
        if (root.start <= index && index <= mid) {
            modifySegmentTree(root.left, index, value);
        }
        if (root.end >= index && index > mid) {
            modifySegmentTree(root.right, index, value);
        }
        // 更新完最底下的值后要把沿途遇到所有的值都更新了
        root.sum = root.left.sum + root.right.sum;
    }

    /*
    * @param A: An integer array
    */
    public Solution(int[] A) {
        // do intialization if necessary
        root = build(0, A.length - 1, A);
    }

    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return querySegmentTree(root, start, end);
    }

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        // write your code here
        modifySegmentTree(root, index, value);
    }
}
