/**
* Two Sum III - Data structure design
* Design and implement a TwoSum class. It should support the following operations: add and find.
* Time complexity: O(n)
*/

public class TwoSum {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (int curNum: map.keySet()) {
            int diff = value - curNum;
            if (map.containsKey(diff)) {
                if (diff != curNum || map.get(diff) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
