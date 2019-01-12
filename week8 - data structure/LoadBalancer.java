/**
* Load Balancer
* Implement a load balancer for web servers. It provide the following functionality:
*  Add a new server to the cluster => add(server_id).
*  Remove a bad server from the cluster => remove(server_id).
*  Pick a server in the cluster randomly with equal probability => pick().

* same as Insert Delete GetRandom O(1)
*/

public class LoadBalancer {

    public List<Integer> nums;
    public HashMap<Integer, Integer> locs;
    public java.util.Random rand = new java.util.Random();

    public LoadBalancer() {
        // do intialization if necessary
        nums = new ArrayList<Integer>(); // store num value
        locs = new HashMap<Integer, Integer>();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        locs.put(server_id, nums.size()); // else we add the number in it, and its index
        nums.add(server_id);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        int loc = locs.get(server_id); // get the index of the val
        int lastOne = nums.get(nums.size() - 1);
        nums.set(loc, lastOne); // move the last one to the current index of val
        locs.put(lastOne, loc); // update the index of the lastOne on the map
        locs.remove(server_id); // remove it from the map
        nums.remove(nums.size() - 1); // remove it from the arraylist
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        return nums.get(rand.nextInt(nums.size()));
    }
}
