/**
* Subsets II
* Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
* Time complexity: O(2 ^ n) 一共这么多可能的结果
* DFS
*/

public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null){
            return results;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<Integer>();
        subsetHelper(nums, results, 0, subset);
        return results;
    }

    private void subsetHelper(int[] nums, List<List<Integer>> results, int startIndex, List<Integer> subset){
        // deep copy
        results.add(new ArrayList(subset));
        for(int i = startIndex; i < nums.length; i ++){
          //  如果有两个相同的数，第一个数选为代表
          // 如果第一个数没有被加入当前的subsets而第二个数要被加进去了
          // 就会有重复，continue
          // i != startIndex 说明至少跳了1个数
            if(i != 0 && nums[i] == nums[i - 1] && i != startIndex){
                continue;
            }
            subset.add(nums[i]);
            subsetHelper(nums, results, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
