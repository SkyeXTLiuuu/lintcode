/**
* 4Sum
* Find all unique quadruplets in the array which gives the sum of target
* Time complexity: O(n^2)
*/

public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return list;
        }
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        Arrays.sort(numbers);

        // add two sum to a map
        for (int i = 0; i < numbers.length; i ++) {
            for (int j = i + 1; j < numbers.length; j ++) {
                int sum = numbers[i] + numbers[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<Integer[]>());
                }
                Integer[] pair = {i, j};
                map.get(sum).add(pair);
            }
        }

        //
        for (int i = 0; i < numbers.length; i ++) {
            if (i != 0 && numbers[i - 1] == numbers[i]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length; j ++) {
                if (j != i + 1 && numbers[j - 1] == numbers[j]) {
                    continue;
                }
                int sum = numbers[i] + numbers[j];
                int curTarget = target - sum;
                // avoid value duplicates 
                int previousNum1 = Integer.MAX_VALUE;
                int previousNum2 = Integer.MAX_VALUE;
                if (map.containsKey(curTarget)) {
                    for (Integer[] p: map.get(curTarget)) {
                        int num1 = p[0];
                        int num2 = p[1];
                        // previousNum1 < previousNum2
                        if (num1 > j && num2 > j && numbers[num1] != previousNum1 &&
                        numbers[num2] != previousNum2) {
                            List<Integer> curList = new ArrayList<>();
                            curList.add(numbers[i]);
                            curList.add(numbers[j]);
                            curList.add(numbers[num1]);
                            curList.add(numbers[num2]);
                            list.add(curList);
                            // previousNum1 < previousNum2
                            previousNum1 = numbers[num1];
                            previousNum2 = numbers[num2];
                        }
                    }
                }
            }
        }
        return list;
    }
}
