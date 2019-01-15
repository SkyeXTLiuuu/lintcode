/**
* Find Median from Data Stream
* Numbers keep coming, return the median of numbers at every time a new number added.
* Time complexity: O(nlogn)
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */

    public PriorityQueue<Integer> maxHeap; // store the smaller half
    public PriorityQueue<Integer> minHeap; // store the larger half
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }

        Comparator<Integer> maxComparator = new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        };

        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(maxComparator);
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i ++) {
            addValue(nums[i], i);
            result[i] = getMedian();
        }
        return result;
    }

    public void addValue(int num, int index) {
        maxHeap.add(num);
        if (index % 2 == 0) {
            if (minHeap.size() == 0) {
                return ;
            }
            else if (maxHeap.peek() > minHeap.peek()) {
                int min = minHeap.poll();
                int max = maxHeap.poll();
                minHeap.offer(max);
                maxHeap.offer(min);
            }
        }
        else {
            minHeap.offer(maxHeap.poll());
        }
    }

    public int getMedian() {
        return maxHeap.peek();
    }
}
