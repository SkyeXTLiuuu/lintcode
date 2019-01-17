/**
* Intersection of Arrays
* Give a number of arrays, find their intersection, and output their intersection size.
* Given [[1,2,3],[3,4,5],[3,9,10]], return 1 => Only element 3 appears in all arrays, the intersection is [3], and the size is 1.
*
* PriorityQueue
* 假设每个数组的长度为n，一共k个数组
* Time complexity: O(knlogn + nklogk) knlogn 是对k个数组进行分别排序的时间复杂度 nklogk是总共nk个数从PriorityQueue中进出，每次进出logk
* Space complexity: O(k) 多少个数组就花费多少额外空间
*/

class Pair {
    int row;
    int col;

    public Pair (int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        // write your code here
        if (arrs == null || arrs.length == 0) {
            return 0;
        }

        Comparator<Pair> comparator = new Comparator<Pair>() {
            public int compare(Pair x, Pair y) {
                return arrs[x.row][x.col] - arrs[y.row][y.col];
            }
        };
        // 按照数字大小输出
        Queue<Pair> queue = new PriorityQueue<>(arrs.length, comparator);

        for (int i = 0; i < arrs.length; i ++) {
            if (arrs[i].length == 0) {
                return 0;
            }
            Arrays.sort(arrs[i]);
            queue.offer(new Pair(i, 0));
        }

        int lastValue = 0;
        int count = 0;
        int intersection = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            // 如果一个相同的数字结束了
            if (arrs[pair.row][pair.col] != lastValue || count == 0) {
                // 如果这个数字的数量在每个里面都出现过了（一个里面没有重复的）
                if (count == arrs.length) {
                    intersection ++;
                }
                // 更换lastValue
                lastValue = arrs[pair.row][pair.col];
                count = 1;
            }
            // 如果还是之前那个数
            else {
                count ++;
            }
            // 把同一个array里面的下一位push进去
            pair.col ++;
            if (pair.col < arrs[pair.row].length) {
                queue.offer(pair);
            }
        }
        // 对于最后一个数的处理
        if (count == arrs.length) {
            intersection ++;
        }

        return intersection;
    }
}
