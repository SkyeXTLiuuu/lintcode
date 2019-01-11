/**
* Next Permutation
* Rearrange numbers into the lexicographically next greater permutation of numbers.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        int[] result = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return result;
        }
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i --) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            result = reverse(nums);
        }

        else {
            // fill up the initial position of result
            for (int i = 0; i < index; i ++) {
                result[i] = nums[i];
            }

            int biggerIndex = index + 1; // initial larger digit
            for (int i = nums.length - 1; i > index; i --) {
                if (nums[i] > nums[index]) {
                    biggerIndex = i;
                    break;
                }
            }
            int tmp = nums[index]; // swap
            nums[index] = nums[biggerIndex];
            nums[biggerIndex] = tmp;

            result[index] = nums[index];

            // reverse
            int lastDigit = nums.length - 1;
            for (int i = index + 1; i < nums.length; i ++) {
                result[i] = nums[lastDigit];
                lastDigit --;
            }
        }

        return result;
    }

    private int[] reverse(int[] nums) {
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            result[end] = nums[i];
            end --;
        }
        return result;
    }
}
