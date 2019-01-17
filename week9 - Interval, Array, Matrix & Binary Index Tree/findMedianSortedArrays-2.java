/**
* Median of two Sorted Arrays
* There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
* Time complexity: O(log(range)∗(log(n)+log(m)))
* 二分答案
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
        if (n % 2 == 0) {
            return (findKth(A, B, n / 2) + findKth(A, B, n / 2 + 1)) / 2.0;
        }
        return findKth(A, B, n / 2 + 1);
    }

    public int findKth(int[] A, int[] B, int k) {
        if (A.length == 0) {
            return B[k - 1]; // 从个数换回index
        }
        if (B.length == 0) {
            return A[k - 1];
        }

        int start = Math.min(A[0], B[0]);
        int end = Math.max(A[A.length - 1], B[B.length - 1]);

        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if (countSmallerOrEqual(A, mid) + countSmallerOrEqual(B, mid) < k) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (countSmallerOrEqual(A, start) + countSmallerOrEqual(B, start) >= k) {
            return start;
        }
        return end;
    }

    private int countSmallerOrEqual(int[] arr, int number) {
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= number) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (arr[start] > number) {
            return start;
        }
        if (arr[end] > number) {
            return end;
        }
        return arr.length;
    }
}
