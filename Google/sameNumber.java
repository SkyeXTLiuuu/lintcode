/**
* Same Number
* If the same number exists in the array, and the distance of the same number is less than the given value k, output YES, otherwise output NO.
* example: Given array = [1,2,3,1,5,9,3], k = 4, return "YES".
* Time complexity:
* Space complexity:
*/

public class Solution {
    /**
     * @param nums: the arrays
     * @param k: the distance of the same number
     * @return: the ans of this question
     */
    public String sameNumber(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return "YES";
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) < k) {
                return "YES";
            }
            map.put(nums[i], i);
        }
        return "NO";
    }
}
