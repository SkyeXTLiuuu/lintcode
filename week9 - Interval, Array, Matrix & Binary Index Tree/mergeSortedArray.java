/**
* Merge Two Sorted Arrays
* Merge two given sorted integer array A and B into a new sorted integer array
* Time complexity:
* Space complexity:
*/

public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) {
            return null;
        }

        int length = A.length + B.length;
        int[] result = new int[length];
        int index = 0;
        int indexA = 0;
        int indexB = 0;

        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] < B[indexB]) {
                result[index] = A[indexA];
                indexA ++;
            }
            else {
                result[index] = B[indexB];
                indexB ++;
            }
            index ++;
        }

        while (indexA < A.length) {
            result[index] = A[indexA];
            indexA ++;
            index ++;
        }

        while (indexB < B.length) {
            result[index] = B[indexB];
            indexB ++;
            index ++;
        }

        return result;
    }
}
