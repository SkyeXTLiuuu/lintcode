/**
* Insert Interval
* Insert IntervalInsert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).
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
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        // 不用加intervals.size（） == 0 因为向空队列中加入一个元素是作为唯一一个元素包进去的
        if (intervals == null || newInterval == null) {
            return intervals;
        }

        List<Interval> results = new ArrayList<>();
        int inserPosition = 0;

        for (Interval i: intervals) {
            if (i.end < newInterval.start) {
                results.add(i);
                inserPosition ++;
            }
            else if (i.start > newInterval.end) {
                results.add(i);
            }
            else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        results.add(inserPosition, newInterval);
        return results;
    }
}
