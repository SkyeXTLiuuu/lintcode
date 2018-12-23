/**
* Search in a Big Sorted Array
* Find the first index of a target number in a big sorted array with positive integers.
* Time complexity: O(k) k is the first index of a given target number 
*/

public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int start = 0;
        int end = getEnd(reader, target);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }

    public int getEnd(ArrayReader reader, int target){
        int end = 1;
        while (target > reader.get(end)) {
            end = end * 2;
        }
        return end;
    }
}
