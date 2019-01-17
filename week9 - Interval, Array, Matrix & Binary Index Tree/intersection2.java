/**
* Intersection of Two Arrays II
* Given two arrays, write a function to compute their intersection.
* example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
* HashMap
* Time complexity:
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

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        List<Integer> resultList = new ArrayList<Integer>();
        for (int num: nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                resultList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i ++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
