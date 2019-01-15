/**
*  Insert Delete GetRandom O(1) - Duplicates allowed
* Design a data structure that supports all following operations in average O(1) time.
* insert(val), remove(val), getRandom
*/

class RandomizedCollection {

    public List<Integer> nums;
    public HashMap<Integer, Set<Integer>> map; // 存的是index, 因为可以有重复，所以是一个set
    public java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // write your code here
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        // write your code here
        if (!map.containsKey(val)) {
            return false;
        }
        // 如果他不是最后一个，我们要把他换到最后一个的位置去
        // swap process
        if (!map.get(val).contains(nums.size()-1)) {
            int currPos = map.get(val).iterator().next(); // get the first appearance of the number
            int lastVal = nums.get(nums.size() - 1); // last number
            map.get(lastVal).remove(nums.size() - 1); // delete the last index of the last number
            map.get(lastVal).add(currPos); // add it to the position of the val (swap)
            map.get(val).remove(currPos); // remove val from the current position
            map.get(val).add(nums.size() - 1); // add val to the end of the list (swap)
            nums.set(currPos, lastVal); // update the change in the nums array
        }

        // delete from the map
        map.get(val).remove(nums.size()-1);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        // delete from list
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        // write your code here
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
