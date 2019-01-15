/**
* High Five
* There are two properties in the node student id and scores, to ensure that each student will have at least 5 points,
* find the average of 5 highest scores for each person.
*/

/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> average_score = new HashMap<>();
        Map<Integer, Queue<Integer>> scores = new HashMap<>();

        if (results == null || results.length == 0) {
            return average_score;
        }

        for (int i = 0; i < results.length; i ++) {
            int student_id = results[i].id;
            if (!scores.containsKey(student_id)) {
                scores.put(student_id, new PriorityQueue<Integer>());
            }
            Queue<Integer> student_score = scores.get(student_id);
            if (student_score.size() < 5) {
                student_score.offer(results[i].score);
            }
            else {
                if (student_score.peek() < results[i].score) {
                    student_score.poll();
                    student_score.offer(results[i].score);
                }
            }
        }

        for (int id: scores.keySet()) {
            Queue<Integer> student_score = scores.get(id);
            double avg = 0;
            while (!student_score.isEmpty()) {
                avg += student_score.poll();
            }
            avg = avg / 5;
            average_score.put(id, avg);
        }

        return average_score;
    }
}
