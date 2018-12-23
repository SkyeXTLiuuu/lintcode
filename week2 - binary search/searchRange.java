/**
* Search for a Range
* Given a sorted array of n integers, find the starting and ending position of a given target value.
* Time complexity: O(logn)
*/

public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        int start = getFirstPosition(A, target);
        if(start == -1) {
            return new int[]{-1, -1};
        }
        int end = getLastPosition(A, start, target);
        return new int[]{start, end};
    }

    public int getFirstPosition(int[] A, int target) {
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
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }

    public int getLastPosition(int[] A, int row, int target) {
        // write your code here
        int start = row;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (A[end] == target) {
            return end;
        }
        if (A[start] == target) {
            return start;
        }
        return -1;
    }
}
