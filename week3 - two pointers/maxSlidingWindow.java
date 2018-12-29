/**
* Sliding Window Maximum
* Move the window at each iteration from the start of the array
* Find the maximum number inside the window at each moving.
* Time complexity: O(n)
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;
        int[] leftWindow = buildLeftWindow(nums, k);
        int[] rightWindow = buildRightWindow(nums, k);

        for (int i = 0; i < length - k + 1; i ++) {
            result.add(Math.max(leftWindow[i + k - 1], rightWindow[i]));
        }
        return result;
    }

    public int[] buildLeftWindow(int[] nums, int k) {
        int length = nums.length;
        int[] leftWindow = new int[length];
        leftWindow[0] = nums[0];
        for (int i = 1; i < length; i ++) {
            if (i % k == 0) {
                leftWindow[i] = nums[i];
            }
            else {
                leftWindow[i] = Math.max(nums[i], leftWindow[i - 1]);
            }
        }
        return leftWindow;
    }

     public int[] buildRightWindow(int[] nums, int k) {
        int length = nums.length;
        int[] rightWindow = new int[length];
        rightWindow[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i --) {
            if (i % k == 0) {
                rightWindow[i] = nums[i];
            }
            else {
                rightWindow[i] = Math.max(nums[i], rightWindow[i + 1]);
            }
        }
        return rightWindow;
    }
}
