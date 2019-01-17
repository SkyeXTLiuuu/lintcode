/**
* Merge Sorted Array
* Given two sorted integer arrays A and B, merge B into A as one sorted array.
* example: A = [1, 2, 3, empty, empty], B = [4, 5] => After merge, A will be filled as [1, 2, 3, 4, 5]
* Time complexity:
* Space complexity:
*/

public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        if (A == null || B == null) {
            return ;
        }

        int index = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if(A[m] > B[n]) {
                A[index] = A[m];
                m --;
            }
            else {
                A[index] = B[n];
                n --;
            }
            index --;
        }

        while (n >= 0) {
            A[index] = B[n];
            n --;
            index --;
        }
    }
}
