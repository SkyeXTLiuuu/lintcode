/**
* Intersection of Two Arrays
* Given two arrays, write a function to compute their intersection.
* example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
* sort & merge 
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

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || nums1[i] != temp[index - 1]) {
                    temp[index] = nums1[i];
                    index ++;
                }
                i ++;
                j ++;
            }
            else if (nums1[i] > nums2[j]) {
                j ++;
            }
            else {
                i ++;
            }
        }

        int[] result = new int[index];
        for (int k = 0; k < index; k ++) {
            result[k] = temp[k];
        }

        return result;
    }
}
