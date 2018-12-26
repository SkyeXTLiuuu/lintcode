/**
* Two Sum - Difference equals to target
* Find two numbers that their difference equals to a target value.
* example: [2, 7, 15, 24], target = 5 => [1, 2]
* Time complexity: O(n)
*/

class Pair {
  int index;
  int num;
  public Pair(int index, int num) {
      this.index = index;
      this.num = num;
  }
}

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
        Pair[] pairs = new Pair[length];
        // initialize the Pair array
        for (int i = 0; i < length; i ++) {
            pairs[i] = new Pair(i, nums[i]);
        }
        // make the target value positve
        if (target < 0) {
            target = target * (-1);
        }
        int[] result = new int[2];
        // sort the Pair array
        Arrays.sort(pairs, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.num - p2.num;
            }
        });
        int right = 0;
        for (int i = 0; i < pairs.length; i ++) {
            // two pointers cannot be at the same place (e.g. target = 0)
            if (i == right) {
                right ++;
            }
            // move right
            while (right < pairs.length && pairs[right].num - pairs[i].num < target) {
                right ++;
            }
            // find target
            if (right < pairs.length && pairs[right].num - pairs[i].num == target) {
                result[0] = pairs[i].index + 1;
                result[1] = pairs[right].index + 1;
                if (result[0] > result[1]) {
                    int tmp = result[0];
                    result[0] = result[1];
                    result[1] = tmp;
                }
                break;
            }
        }
        return result;
    }
}
