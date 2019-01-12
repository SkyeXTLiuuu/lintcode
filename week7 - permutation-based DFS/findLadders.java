/**
* Word Ladder II
* Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end
*   Only one letter can be changed at a time
*   Each intermediate word must exist in the dictionary
* BFS + DFS 
*/

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (dict == null || dict.size() == 0) {
            return result;
        }

        dict.add(end);
        Map<String, Integer> distance = new HashMap<String, Integer>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        bfs(start, end, dict, distance, map);
        List<String> path = new ArrayList<String>();
        dfs(end, start, map, distance, path, result);
        return result;
    }

    public void dfs(String crt, String start, Map<String, List<String>> map, Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        path.add(crt);
        if (crt.equals(start)) {
            Collections.reverse(path);
            result.add(new ArrayList<String>(path));
            Collections.reverse(path);
        }
        else {
            for (String next: map.get(crt)) {
            if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
                    dfs(next, start, map, distance, path, result);
                }
            }
        }
        path.remove(path.size() - 1);
    }


    public void bfs(String start, String end, Set<String> dict, Map<String, Integer> distance, Map<String, List<String>> map) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        for (String s: dict) {
            map.put(s, new ArrayList<String>());
        }

        while (!queue.isEmpty()) {
            String word = queue.poll();
            List<String> neighbor = getNeighbor(word, dict);

            for (String next: neighbor) {
                map.get(next).add(word);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(word) + 1);
                    queue.offer(next);
                }
            }
        }
    }

    public List<String> getNeighbor(String word, Set<String> dict) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i ++) {
            for (char c = 'a'; c <= 'z'; c ++) {
                String neighbor = word.substring(0, i) + c + word.substring(i + 1, word.length());
                if (neighbor.equals(word)) {
                    continue;
                }
                if (dict.contains(neighbor)) {
                    list.add(neighbor);
                }
            }
        }
        return list;
    }
}
