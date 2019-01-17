/**
* Intersection of Two Arrays
* Given two arrays, write a function to compute their intersection.
* example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
* sort & binary search
* Time complexity:
* Space complexity: 
*/

public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        Arrays.sort(nums1);
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums2.length; i ++) {
            if (set.contains(nums2[i])){
                continue;
            }
            if (binarySearch(nums1, nums2[i])) {
                set.add(nums2[i]);
            }

        }

        int[] result = new int[set.size()];
        int i = 0;
        for (int num: set) {
            result[i] = num;
            i ++;
        }
        return result;
    }

    private boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return true;
        }
        if (nums[end] == target) {
            return true;
        }

        return false;
    }
}
