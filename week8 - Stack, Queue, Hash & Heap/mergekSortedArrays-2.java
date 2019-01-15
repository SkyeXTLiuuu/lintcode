/**
* Merge K Sorted Arrays
* Given k sorted integer arrays, merge them into one sorted array.
* Priority Queue
* Time complexity: O(nlogk)
*/

class Element {
    int val;
    int row;
    int col;

    public Element(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

public class Solution {

    public Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element left, Element right) {
            return left.val - right.val;
        }
    };

    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }

        Queue<Element> pq = new PriorityQueue<Element>(arrays.length, ElementComparator);
        int length = 0;
        for (int i = 0; i < arrays.length; i ++) {
            // [[], []]
            if (arrays[i].length == 0) {
                continue;
            }
            pq.offer(new Element(arrays[i][0], i, 0));
            length = length + arrays[i].length;
        }

        int[] result = new int[length];
        int index = 0;

        while (!pq.isEmpty()) {
            Element cur = pq.poll();
            result[index] = cur.val;
            index ++;

            if (cur.col + 1 < arrays[cur.row].length) {
                cur.col = cur.col + 1;
                cur.val = arrays[cur.row][cur.col];
                pq.offer(cur);
            }
        }

        return result;
    }
}
