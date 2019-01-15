/**
* Top k Largest Numbers II
* Implement a data structure, provide two interfaces:
*     add(number). Add a new number in the data structure.
*     topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.
*/

public class Solution {

    public Queue<Integer> queue;
    public int size;
    /*
    * @param k: An integer
    */public Solution(int k) {
        // do intialization if necessary
        queue = new PriorityQueue<Integer>();
        size = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        queue.offer(num);
        if (queue.size() > size) {
            queue.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> result = new ArrayList<>(queue);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
