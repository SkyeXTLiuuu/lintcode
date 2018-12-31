/**
* Sequence Reconstruction
* Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs
* Time complexity:
*/

public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int num: org) {
            map.put(num, new HashSet<Integer>());
            indegree.put(num, 0);
        }

        int n = org.length;
        int count = 0;
        for (int[] seq: seqs) {
            count += seq.length;
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n)) {
                return false;
            }
            for (int i = 1; i < seq.length; i ++) {
                if (seq[i] <= 0 || seq[i] > n) {
                    return false;
                }
                // 没看懂 ？？？
                if(map.get(seq[i - 1]).add(seq[i])) {
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }

        // case: [1] []
        if (count < n) {
            return false;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int key: indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.add(key);
            }
        }

        int cnt = 0;
        while (queue.size() == 1) {
            int ele = queue.poll();
            for (int next: map.get(ele)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
            if (ele != org[cnt]) {
                return false;
            }
            cnt ++;
        }

        return cnt == org.length;
    }
}
