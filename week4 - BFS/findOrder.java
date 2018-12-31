/**
* Course Schedule II
* Given the total number of courses and a list of prerequisite pairs,
* return the ordering of courses you should take to finish all courses.
* Is it possible for you to finish all courses
* Time complexity:
*/

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        if (prerequisites == null) {
            return new int[]{0};
        }

        int[] count = new int[numCourses];
        List[] edge = new ArrayList[numCourses];

        // initialize the edge array
        for (int i = 0; i < numCourses; i ++) {
            edge[i] = new ArrayList<Integer>();
        }
        int[] order = new int[numCourses];
        int index = 0;

        // count the degrees
        // 注意prerequisite是放在后面的那个
        for (int i = 0; i < prerequisites.length; i ++) {
            count[prerequisites[i][0]] ++; // 为了上这个课的先修再加一个
            edge[prerequisites[i][1]].add(prerequisites[i][0]); // 这个课是其他的先修
        }

        // 把没有先修的课先加进去
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i ++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            order[index] = course;
            index ++;
            int n = edge[course].size();
            for (int i = 0; i < n; i ++) {
                int pointer = (int) edge[course].get(i);
                count[pointer] --;
                if (count[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }

        if (index == numCourses) {
            return order;
        }
        return new int[0];
    }
}
