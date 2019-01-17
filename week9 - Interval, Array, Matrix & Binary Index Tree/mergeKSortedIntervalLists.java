/**
* Merge K Sorted Interval Lists
* Merge K sorted interval lists into one sorted interval list. You need to merge overlapping intervals too.
* Merge sort 
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
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<Interval>();
        }
        return mergeHelper(intervals, 0, intervals.size() - 1);
    }

    public List<Interval> mergeHelper(List<List<Interval>> intervals, int start, int end) {
        if (start >= end) {
            return intervals.get(start);
        }
        int mid = (start + end) / 2;
        List<Interval> left = mergeHelper(intervals, start, mid);
        List<Interval> right = mergeHelper(intervals, mid + 1, end);
        return mergeTwoInterval(left, right);
    }

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
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
