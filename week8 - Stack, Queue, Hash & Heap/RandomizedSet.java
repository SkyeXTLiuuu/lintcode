/**
* Insert Delete GetRandom O(1)
* Design a data structure that supports all following operations in average O(1) time.
* insert(val), remove(val), getRandom
*/

class RandomizedSet {
    public List<Integer> nums;
    public HashMap<Integer, Integer> locs;
    public java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
      nums = new ArrayList<Integer>(); // store num value
      locs = new HashMap<Integer, Integer>(); // key is the num value, value is the index in nums arraylist
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      // check whether we have include this number before
      boolean contain = locs.containsKey(val);
      if(contain){
        return false;
      }
      locs.put(val, nums.size()); // else we add the number in it, and its index
      nums.add(val);
      return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      // check whether we have that number
      boolean contain = locs.containsKey(val);
      if(!contain){
        return false;
      }
      int loc = locs.get(val); // get the index of the val
      if(loc < nums.size() - 1){ // the val is not the last one in the list
        // we swap it with the last one, move val to the end for deleting
        int lastOne = nums.get(nums.size() - 1);
        nums.set(loc, lastOne); // move the last one to the current index of val
        locs.put(lastOne, loc); // update the index of the lastOne on the map
      }
      locs.remove(val); // remove it from the map
      nums.remove(nums.size() - 1); // remove it from the arraylist
      return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
