/**
* Median of K Sorted Arrays
* There are k sorted arrays nums. Find the median of the given k sorted arrays.
* Time complexity:
*/

public class Solution {
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    public double findMedian(int[][] nums) {
        // write your code here
        int n = getTotal(nums);
        if (n == 0) {
            return 0;
        }

        if (n % 2 != 0) {
            return findKth(nums, n / 2 + 1);
        }
        return findKth(nums, n / 2) / 2.0 + findKth(nums, n / 2 + 1) / 2.0;
    }

    private int findKth(int[][] nums, int k) {
        int start = 0;
        int end = Integer.MAX_VALUE;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getGTE(nums, mid) >= k) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (getGTE(nums, start) >= k) {
            return start;
        }
        return end;
    }

    // matrix
    private int getGTE(int[][] nums, int val) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += getGTE(nums[i], val);
        }
        return sum;
    }

    // array
    private int getGTE(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= val) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if (nums[start] >= val) {
            return nums.length - start;
        }

        if (nums[end] >= val) {
            return nums.length - end;
        }
        return 0;
    }


    // count the number of total numbers in the matrix
    private int getTotal(int[][] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i].length;
        }
        return sum;
    }
}
