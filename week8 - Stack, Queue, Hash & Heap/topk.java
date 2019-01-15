/**
* Top k Largest Numbers
* Given an integer array, find the top k largest numbers in it.
* Priority Queue
* Time complexity: O(nlogn)
*/

public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here

        if (nums == null || nums.length == 0 || k < 1) {
            return new int[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (i < k) {
                pq.offer(nums[i]);
            }
            else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }

        int[] result = new int[k];
        while (k > 0) {
            result[k - 1] = pq.poll();
            k --;
        }

        return result;
    }
}
