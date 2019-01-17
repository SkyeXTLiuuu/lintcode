/**
* Merge K Sorted Interval Lists
* Merge K sorted interval lists into one sorted interval list. You need to merge overlapping intervals too.
* PriorityQueue
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
class Pair {
    int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        int k = intervals.size();
        // sort by the starting point
        PriorityQueue<Pair> queue = new PriorityQueue<>(
            k, new Comparator<Pair>() {
                public int compare(Pair e1, Pair e2) {
                    return intervals.get(e1.row).get(e1.col).start -
                        intervals.get(e2.row).get(e2.col).start;
                }
            }
        );

        for (int i = 0; i < k; i ++) {
            if (intervals.get(i).size() > 0) {
                queue.add(new Pair(i, 0));
            }
        }

        List<Interval> result = new ArrayList<>();
        // 把所有interval按照starting point的顺序加进去
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            result.add(intervals.get(pair.row).get(pair.col));
            pair.col ++;
            if (pair.col < intervals.get(pair.row).size()) {
                queue.add(pair);
            }
        }

        return merge(result);
    }

    // merge one final long interval list 
    private List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval: intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            }
            else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // kick off the last interval
        result.add(new Interval(start, end));

        return result;
    }
}
