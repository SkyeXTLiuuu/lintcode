/**
* Longest Consecutive Sequence
* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
* e.g. Given [100, 4, 200, 1, 3, 2] => [1, 2, 3, 4]. Return its length: 4
*/

public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int n: num) {
            set.add(n);
        }

        for (int i = 0; i < num.length; i ++) {
            int count = 1;
            int left = num[i] - 1;
            int right = num[i] + 1;
            while (set.contains(left)) {
                count ++;
                set.remove(left);
                left --;
            }
            while (set.contains(right)) {
                count ++;
                set.remove(right);
                right ++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
