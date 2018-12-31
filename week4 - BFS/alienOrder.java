/**
* Alien Dictionary
* You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
* Derive the order of letters in this language.
* Time complexity:
*/

public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> graph = constructGraph(words);
        return topologicalOrder(graph);
    }

    private Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        // create nodes
        for (int i = 0; i < words.length; i ++) {
            for (int j = 0; j < words[i].length(); j ++) {
                if (!graph.containsKey(words[i].charAt(j))) {
                    graph.put(words[i].charAt(j), new HashSet<Character>());
                }
            }
        }

        // create edge
        for (int i = 0; i < words.length - 1; i ++) {
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()) {
                if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                    // prefix
                    graph.get(words[i].charAt(index)).add(words[i + 1].charAt(index));
                    break;
                }
                index ++;
            }
        }
        return graph;
    }

    private String topologicalOrder(Map<Character, Set<Character>> graph) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> degree = getIndegree(graph);
        Queue<Character> queue = new PriorityQueue<>();
        for (Character u: degree.keySet()) {
            if (degree.get(u) == 0) {
                queue.offer(u);
            }
        }

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            for (Character n: graph.get(c)) {
                degree.put(n, degree.get(n) - 1);
                if (degree.get(n) == 0) {
                    queue.offer(n);
                }
            }
        }
        if (sb.length() != degree.size()) {
            return "";
        }
        return sb.toString();
    }

    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> degree = new HashMap<>();
        for (Character c: graph.keySet()) {
            degree.put(c, 0);
        }

        for (Character c: graph.keySet()) {
            for (Character u: graph.get(c)) {
                degree.put(u, degree.get(u) + 1);
            }
        }
        return degree;
    }
}
