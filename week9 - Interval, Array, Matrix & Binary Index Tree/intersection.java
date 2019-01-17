/**
* Intersection of Two Arrays
* Given two arrays, write a function to compute their intersection.
* example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
* HashSet
* Time complexity:
* Space complexity: O(n + i) n is the length of num1, i is the number of intersections
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
        Set<Integer> set = new HashSet<>();
        Set<Integer> unique = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }
        for (int num: nums2) {
            if (set.contains(num)) {
                unique.add(num);
            }
        }
        int[] result = new int[unique.size()];
        int i = 0;
        for (int num: unique) {
            result[i] = num;
            i ++;
        }
        return result;
    }
}
