/**
* Moving Average from Data Stream
* Given a stream of integers and a window size, 
* Calculate the moving average of all integers in the sliding window.
*/

public class MovingAverage {

    private Queue<Integer> queue;
    private double sum = 0;
    private int size;

    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        queue = new LinkedList<Integer>();
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
        sum = sum + val;
        if (queue.size() == size) {
            sum = sum - queue.poll();
        }
        queue.offer(val);
        return sum / queue.size();
    }
}
