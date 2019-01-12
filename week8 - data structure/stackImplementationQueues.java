/**
* Implement Stack by Two Queues
*/

public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        // write your code here
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        if (queue1.isEmpty()) {
            return ;
        }
        moveItems();
        queue1.poll();
        swap();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (queue1.isEmpty()) {
            return -1;
        }
        moveItems();
        int top = queue1.poll();
        swap();
        queue1.offer(top);
        return top;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return queue1.isEmpty();
    }

    public void swap() {
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public void moveItems() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
}
