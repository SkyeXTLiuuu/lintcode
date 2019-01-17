/**
* Subarray Sum Closest
* Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
* example: Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
* Time complexity: O(nlogn)
*/

class Element implements Comparable<Element>{
    int sum;
    int index;

    public Element(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }

    public int compareTo(Element e) {
        return this.sum - e.sum;
    }
}

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[2];
        }

        Element[] prefix = new Element[nums.length + 1];
         prefix[0] = new Element(0, 0);

        for (int i = 1; i < nums.length + 1; i ++) {
            prefix[i] = new Element(nums[i - 1] + prefix[i - 1].sum, i);
        }

        Arrays.sort(prefix);

        int ans = Integer.MAX_VALUE;
        int[] res = new int[2];

        for (int i = 1; i <= nums.length; i++) {
            if (ans > prefix[i].sum - prefix[i-1].sum) {
                ans = prefix[i].sum - prefix[i-1].sum;
                int[] temp = new int[]{prefix[i].index - 1, prefix[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }

        return res;
    }
}
