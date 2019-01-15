/**
* Implement Three Stacks by Single Array
* You can assume the three stacks has the same size and big enough, you don't need to care about how to extend it if one of the stack is full.
* List and Pointers (prev, next)
*/

class StackNode {
    public int prev, next;
    public int value;
    public StackNode(int p, int v, int n) {
        value = v;
        prev = p;
        next = n;
    }
}

public class ThreeStacks {
    public int stackSize; // the size of each stack
    public int indexUsed; // the next available position to add values in the array
    public int[] stackPointer; // an array to store the last input of each stack
    public StackNode[] buffer; // the array to store elements

    /*
    * @param size: An integer
    */
    public ThreeStacks(int size) {
        // do intialization if necessary
        stackSize = size;
        stackPointer = new int[3];
        for (int i = 0; i < 3; i ++) {
            stackPointer[i] = -1;
        }
        indexUsed = 0;
        buffer = new StackNode[stackSize * 3]; // three stacks have the same size
    }

    /*
     * @param stackNum: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void push(int stackNum, int value) {
        // Push value into stackNum stack
        int lastIndex = stackPointer[stackNum];
        stackPointer[stackNum] = indexUsed; // 当前可用位置
        indexUsed ++;
        buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value, -1); // prev is the node located at lastIndex
        // 如果不是第一个node的话，把之前那个末尾的next和当前的node连在一起
        if (lastIndex != -1) {
            buffer[lastIndex].next = stackPointer[stackNum];
        }
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int pop(int stackNum) {
        // Pop and return the top element from stackNum stack
        if (isEmpty(stackNum)) {
            return -1;
        }
        int value = buffer[stackPointer[stackNum]].value;
        int lastIndex = stackPointer[stackNum];
        // 如果不是最后添加的那个点，就要和最后一位换并update
        // 否则这个array里就会有漏洞
        if (lastIndex != indexUsed - 1) {
            swap(lastIndex, indexUsed - 1, stackNum);
        }

        stackPointer[stackNum] = buffer[stackPointer[stackNum]].prev; // 结尾的index改成了当前node的前一位
        // 因为要删除当前点的next，所以坐标设置为-1
        if (stackPointer[stackNum] != -1) {
            buffer[stackPointer[stackNum]].next = -1;
        }
        // 删除这个点
        buffer[indexUsed - 1] = null;
        indexUsed --;
        return value;
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int peek(int stackNum) {
        // Return the top element
        if (isEmpty(stackNum)) {
            return -1;
        }
        return buffer[stackPointer[stackNum]].value;
    }

    /*
     * @param stackNum: An integer
     * @return: true if the stack is empty else false
     */
    public boolean isEmpty(int stackNum) {
        // write your code here
        return stackPointer[stackNum] == -1;
    }

    public void swap(int lastIndex, int topIndex, int stackNum) {
        if (buffer[lastIndex].prev == topIndex) {
            int tmp = buffer[lastIndex].value;
            buffer[lastIndex].value = buffer[topIndex].value;
            buffer[topIndex].value = tmp;

            int tp = buffer[topIndex].prev;
            if (tp != -1) {
                buffer[tp].next = lastIndex;
            }
            buffer[lastIndex].prev = tp;

            buffer[lastIndex].next = topIndex;
            buffer[topIndex].prev = lastIndex;
            buffer[topIndex].next = -1;
            stackPointer[stackNum] = topIndex;
            return;
        }

        int lp = buffer[lastIndex].prev;
        if (lp != -1)
            buffer[lp].next = topIndex;

        int tp = buffer[topIndex].prev;
        if (tp != -1)
            buffer[tp].next = lastIndex;

        int tn = buffer[topIndex].next;
        if (tn != -1)
            buffer[tn].prev = lastIndex;
        else {
            for (int i = 0; i < 3; ++i)
                if (stackPointer[i] == topIndex)
                    stackPointer[i] = lastIndex;
        }

        StackNode tmp = buffer[lastIndex];
        buffer[lastIndex] = buffer[topIndex];
        buffer[topIndex] = tmp;
        stackPointer[stackNum] = topIndex;
    }
}
