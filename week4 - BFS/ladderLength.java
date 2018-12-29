/**
* Word Ladder
* Find the length of shortest transformation sequence from start to end
* Time complexityL: 
*/

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start == null || end == null || dict == null || dict.size() == 0) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }

        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step ++;
            for (int i = 0; i < size; i ++) {
                String curWord = queue.poll();
                List<String> similarWord = getSimilarWord(curWord, dict);
                for (String s: similarWord) {
                    if (s.equals(end)) {
                        return step;
                    }
                    if (!set.contains(s)) {
                        queue.offer(s);
                        set.add(s);
                    }
                }
            }
        }
        return 0;
    }

    public List<String> getSimilarWord(String curWord, Set<String> dict) {
        List<String> similarWord = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c ++) {
            for (int i = 0; i < curWord.length(); i ++) {
                if (c == curWord.charAt(i)) {
                    continue;
                }
                String newWord = replace(curWord, i, c);
                if (dict.contains(newWord)) {
                    similarWord.add(newWord);
                }

            }
        }
        return similarWord;
    }

    public String replace(String curWord, int i, char c) {
        char[] word = curWord.toCharArray();
        word[i] = c;
        return new String(word);
    }
}
