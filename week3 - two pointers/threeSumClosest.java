/**
* 3Sum Closest
* Find three integers in S such that the sum is closest to a given numbe
* Time complexity: O(n^2)
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        Arrays.sort(numbers);
        int diff = Integer.MAX_VALUE;
        // control one point
        for (int i = 0; i < numbers.length; i ++) {
          // use two pointers for the other two points 
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right] + numbers[i];
                if (Math.abs(target - sum) <  Math.abs(target - diff)) {
                    diff = sum;
                }
                if (sum > target) {
                    right --;
                }
                else {
                    left ++;
                }
            }
        }
        return diff;
    }
}
