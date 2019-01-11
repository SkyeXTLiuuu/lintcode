/**
* Subsets
* Given a set of distinct integers, return all possible subsets.
* Time complexity: O(2 ^ n) 一共这么多可能的结果
* BFS
*/

public class Solution {

    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // List vs ArrayList （google）
        List<List<Integer>> results = new LinkedList<>();

        if (nums == null) {
            return results; // 空列表
        }

        Arrays.sort(nums);

        // BFS
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new LinkedList<Integer>());

        while (!queue.isEmpty()) {
            List<Integer> subset = queue.poll();
            results.add(subset);
            // 先加【1】， 【2】， 【3】， 再加【1，2】， 【1，3】 ...
            // 第一层: []
            // 第二层: [1] [2] [3]
            // 第三层: [1, 2] [1, 3], [2, 3]
            // 第四层: [1, 2, 3]
            // 每一层的节点都是上一层的节点拓展而来。
            for (int i = 0; i < nums.length; i++) {
                if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]) {
                    List<Integer> nextSubset = new LinkedList<Integer>(subset);
                    nextSubset.add(nums[i]);
                    queue.offer(nextSubset);
                }
            }
        }

        return results;
    }
}
