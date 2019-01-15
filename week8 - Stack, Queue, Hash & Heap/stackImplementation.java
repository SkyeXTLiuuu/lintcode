/**
* Implement Stack
*/

public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    List<Integer> array = new ArrayList<>();
    public void push(int x) {
        // write your code here
        array.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        if (array.size() == 0) {
            return ;
        }
        array.remove(array.size() - 1);
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (array.size() == 0) {
            return -1;
        }
        return array.get(array.size() - 1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return array.size() == 0;
    }
}
