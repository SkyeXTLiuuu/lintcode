/**
* 3Sum
* Find all unique triplets in the array which gives the sum of zero
* Time complexity: O(n^2)
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return list;
        }

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i ++) {
            if (i > 0 && numbers[i - 1] == numbers[i]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            int target = - numbers[i];
            twoSum(numbers, left, right, target, list);
        }
        return list;
    }

    public void twoSum(int[] numbers, int left, int right, int target, List<List<Integer>> list) {
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ArrayList<Integer> curList = new ArrayList<>();
                curList.add(- target);
                curList.add(numbers[left]);
                curList.add(numbers[right]);
                list.add(curList);
                left ++;
                right --;
                while (left < right && numbers[left - 1] == numbers[left]) {
                    left ++;
                }
                while (left < right && numbers[right + 1] == numbers[right]) {
                    right --;
                }
            }
            else if (numbers[left] + numbers[right] > target) {
                right --;
            }
            else {
                left ++;
            }
        }
    }
}
