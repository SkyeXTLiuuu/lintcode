/**
* LRU Cache
* Design and implement a data structure for Least Recently Used (LRU) cache.
* It should support the following operations: get and set.
* Newest node append to head, oldest node remove from tail
*/

class LinkedNode {
    int key;
    int val;
    LinkedNode prev;
    LinkedNode next;

    public LinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {

    private LinkedNode head, tail;
    private Map<Integer, LinkedNode> map;
    private int capacity;

    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        map = new HashMap<Integer, LinkedNode>();
        this.capacity = capacity;
        head = new LinkedNode(0, 0);
        tail = new LinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        LinkedNode n = map.get(key);
        promoteToHead(n);
        return n.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            node.val = value;
            map.put(key, node);
            promoteToHead(node);
            return ;
        }

        if (map.size() == capacity) {
            LinkedNode prev = tail.prev;
            map.remove(prev.key);
            remove(prev);
        }

        LinkedNode node = new LinkedNode(key, value);
        map.put(key, node);
        addToHead(node);
    }

    private void promoteToHead(LinkedNode n) {
        if (n != head) {
            remove(n);
            addToHead(n);
        }
    }

    private void remove(LinkedNode n) {
        if (n != tail) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        else {
            n.prev.next = null;
        }
    }

    private void addToHead(LinkedNode n) {
        LinkedNode tmp = head.next;
        head.next = n;
        n.prev = head;
        n.next = tmp;
        tmp.prev = n;
    }
}
