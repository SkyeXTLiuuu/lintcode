/**
* Find Peak Element
* Find a peak element in this array.
* Time complexity: O(logN)
*/


public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A ==  null || A.length == 0) {
            return -1;
        }
        int start = 1;
        int end = A.length - 2;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] < A[mid + 1]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (A[start] > A[start + 1] && A[start] > A[start - 1]) {
            return start;
        }
        return end;
    }
}
