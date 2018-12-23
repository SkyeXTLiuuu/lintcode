/**
* Find K Closest Elements
* Find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target.
* Time complexity: O(logn + k)
*/

public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        if (A == null || A.length == 0 || k > A.length) {
            return A;
        }
        if (k == 0) {
            return new int[0];
        }
        int left = findClosest(A, target);
        int right = left + 1;
        int[] results = new int[k];
        for (int i = 0; i < k; i ++) {
            if (isLeftCloser(A, left, right, target)) {
                results[i] = A[left];
                left --;
            }
            else {
                results[i] = A[right];
                right ++;
            }
        }
        return results;
    }

    public boolean isLeftCloser(int[] A, int left, int right, int target){
        if (left < 0) {
           return false;
        }
        if (right >= A.length) {
            return true;
        }
        if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
            return true;
        }
        return false;
    }

    public int findClosest(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
            return start;
        }
        else {
            return end;
        }
    }
}
