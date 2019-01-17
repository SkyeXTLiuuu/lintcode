/**
* Median of two Sorted Arrays
* There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
* Time complexity: O(log(n+m))
* 每次删掉数组中的一部分
*/

public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) {
            return -1;
        }
        int n = A.length + B.length;
        // 取两个数的平均值
        if (n % 2 == 0) {
            return (findKth(A, 0, B, 0, n / 2) + findKth(A, 0, B, 0, n / 2 + 1)) / 2.0;
        }
        return findKth(A, 0, B, 0, n / 2 + 1);
    }

    // k是正常情况下的顺序，而不是index
    public int findKth(int[] A, int Astart, int[] B, int Bstart, int k) {
        // 如果A越界了
        if (Astart >= A.length) {
            return B[Bstart + k - 1];
        }
        // 如果B越界了
        if (Bstart >= B.length) {
            return A[Astart + k - 1];
        }
        // 找两个数组何在一起的第一个数，就是他两比较小的那一个
        if (k == 1) {
            return Math.min(A[Astart], B[Bstart]);
        }
        // 如果某一个数组的长度根本不够去取第k/2个数，就从另一个数组中删去
        // 设置为无穷大他就一定大于另一个数组的值，就会从那个里面删
        int halfKthOfA = Astart + k / 2 - 1 < A.length ? A[Astart + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthOfB = Bstart + k / 2 - 1 < B.length ? B[Bstart + k / 2 - 1] : Integer.MAX_VALUE;
        // 看哪个在k/2的位置小，就把他之前的删去
        if (halfKthOfA < halfKthOfB) {
            return findKth(A, Astart + k / 2, B, Bstart, k - k / 2);
        }
        else {
            return findKth(A, Astart, B, Bstart + k / 2, k - k / 2);
        }
    }
}
