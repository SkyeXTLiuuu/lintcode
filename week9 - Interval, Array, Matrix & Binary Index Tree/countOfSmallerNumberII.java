/**
* Count of Smaller Number before itself
* Count the number of element before this element Ai is smaller than it and return count number array.
* example: For array [1,2,7,8,5], return [0,1,2,3,2]
* binary segment tree
* Time complexity:
*/

public class Solution {

    class SegmentTreeNode {
        public int start, end;
        public int count;
        public SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }

    SegmentTreeNode root;
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }

        return root;
    }

    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (start == root.start && end == root.end) {
            return root.count;
        }

        int mid = (root.start + root.end) / 2;
        int leftCount = 0, rightCount = 0;
        // 左子区
        if (start <= mid) {
            // 分裂
            if (mid < end) {
                leftCount = querySegmentTree(root.left, start, mid);
            }
            // 包含
            else {
                leftCount = querySegmentTree(root.left, start, end);
            }
        }

        if (mid < end) {
            if (start <= mid) {
                rightCount = querySegmentTree(root.right, mid + 1, end);
            }
            else {
                rightCount = querySegmentTree(root.right, start, end);
            }
        }

        return leftCount + rightCount;
    }

    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.count += value;
            return ;
        }

        int mid = (root.start + root.end) / 2;
        if (root.start <= index && index <= mid) {
            modifySegmentTree(root.left, index, value);
        }

        if (mid < index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }

        root.count = root.left.count + root.right.count;
    }

    /**
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here

        root = build(0, 10000);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A.length; i ++) {
            int res = 0;
            // 说明有这个数
            if (A[i] > 0) {
                res = querySegmentTree(root, 0, A[i] - 1);
            }
            modifySegmentTree(root, A[i], 1);
            ans.add(res);
        }
        return ans;
    }
}
