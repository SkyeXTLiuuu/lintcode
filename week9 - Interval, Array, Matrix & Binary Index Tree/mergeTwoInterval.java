/**
* Merge Two Sorted Interval Lists
* Merge two sorted (ascending) lists of interval and return it as a new sorted list. 
* Time complexity:
* Space complexity:
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        if (list1 == null || list2 == null) {
            return null;
        }

        List<Interval> results = new ArrayList<Interval>();
        int i = 0, j = 0;
        Interval last = null;
        Interval curt = null;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                curt = list1.get(i);
                i ++;
            }
            else {
                curt = list2.get(j);
                j ++;
            }
            last = mergeResult(results, curt, last);
        }

        while (i < list1.size()) {
            last = mergeResult(results, list1.get(i), last);
            i ++;
        }

        while (j < list2.size()) {
            last = mergeResult(results, list2.get(j), last);
            j ++;
        }

        if (last != null) {
            results.add(last);
        }
        return results;
    }

    private Interval mergeResult(List<Interval> results, Interval cur, Interval last) {
        if (last == null) {
            return cur;
        }

        if (last.end >= cur.start) {
            last.end = Math.max(last.end, cur.end);
            return last;
        }
        else {
            results.add(last);
            return cur;
        }
    }
}
