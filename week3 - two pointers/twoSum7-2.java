/**
* Two Sum - Difference equals to target
* Find two numbers that their difference equals to a target value.
* example: [2, 7, 15, 24], target = 5 => [1, 2]
* Time complexity: O(n)
* Space complexity: O(n)
*/

public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            int sum = nums[i] + target;
            if (map.containsKey(sum)) {
                int first = map.get(sum);
                return new int[]{first + 1, i + 1};
            }
            int diff = nums[i] - target;
            if (map.containsKey(diff)) {
                int first = map.get(diff);
                return new int[]{first + 1, i + 1};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
