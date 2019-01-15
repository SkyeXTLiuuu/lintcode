/**
* Merge K Sorted Arrays
* Given k sorted integer arrays, merge them into one sorted array.
* Merge sort
* Time complexity: O(nlogk)
*/

public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */

    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }
        return mergeHelper(0, arrays.length - 1, arrays);
    }

    public int[] mergeHelper(int start, int end, int[][] arrays) {
        if (start == end) {
            return arrays[start];
        }
        int mid = (start + end) / 2;
        int[] left = mergeHelper(start, mid, arrays);
        int[] right = mergeHelper(mid + 1, end, arrays);
        return mergeTwoArrays(left, right);
    }

    public int[] mergeTwoArrays(int[] left, int[] right) {
        int length = left.length + right.length;
        int[] result = new int[length];
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[index] = left[leftIndex];
                leftIndex ++;
            }
            else {
                result[index] = right[rightIndex];
                rightIndex ++;
            }
            index ++;
        }

        while (leftIndex < left.length) {
            result[index] = left[leftIndex];
            leftIndex ++;
            index ++;
        }

         while (rightIndex < right.length) {
            result[index] = right[rightIndex];
            rightIndex ++;
            index ++;
        }
        return result;
    }
}
