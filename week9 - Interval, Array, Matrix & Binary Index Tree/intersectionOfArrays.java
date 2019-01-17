/**
* Intersection of Arrays
* Give a number of arrays, find their intersection, and output their intersection size.
* Given [[1,2,3],[3,4,5],[3,9,10]], return 1 => Only element 3 appears in all arrays, the intersection is [3], and the size is 1.
*
* HashMap
* 假设每个数组的长度为n，一共k个数组
* Time complexity: O(nk)
* Space complexity: O(nk) 如果所有的数都不一样
*/

public class Solution {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        // write your code here
        if (arrs == null || arrs.length == 0) {
            return 0;
        }
        Map<Integer, Integer> count = new HashMap<>();

        for (int[] a: arrs) {
            for (int num: a) {
                if (!count.containsKey(num)) {
                    count.put(num, 0);
                }
                count.put(num, count.get(num) + 1);
            }
        }

        int result = 0;

        for (int key: count.keySet()) {
            if (count.get(key) == arrs.length) {
                result ++;
            }
        }
        return result;
    }
}
