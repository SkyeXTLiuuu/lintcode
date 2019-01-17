/**
* Merge Intervals
* Given a collection of intervals, merge all overlapping intervals.
* Time complexity: O(n log n)
* Space complexity: O(1) 
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
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here

        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        Comparator<Interval> comparator = new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2)  {
                return i1.start - i2.start;
            }
        };
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, comparator);
        Interval last = intervals.get(0);

        for (int i = 0; i < intervals.size(); i ++) {
            Interval curt = intervals.get(i);
            if (curt.start <= last.end ){
                last.end = Math.max(last.end, curt.end);
            }
            else {
                result.add(last);
                last = curt;
            }
        }

        result.add(last);
        return result;
    }
}
