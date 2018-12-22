/**
* Subsets 2 - subsets with duplicates
* Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
* Time complexity: O(2 ^ n) the maximum possible number of subsets
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
        // sort for detecting duplicates
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<Integer>();
        subsetHelper(nums, results, 0, subset);
        return results;
    }

    private void subsetHelper(int[] nums, List<List<Integer>> results, int startIndex, List<Integer> subset){
        // deep copy
        results.add(new ArrayList(subset));
        for(int i = startIndex; i < nums.length; i ++){
            // if the number is the same as the number before it and the number before it has not been added
            // [1] [1] will satisfy the if statement
            // [1, 1] will not because i != startIndex when we want to add the second 1
            if(i != 0 && nums[i] == nums[i - 1] && i != startIndex){
                continue;
            }
            // backtacking 
            subset.add(nums[i]);
            subsetHelper(nums, results, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
