/**
* Word Search II
* Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix
* A word can start from any position in the matrix and go left/right/up/down to the adjacent position.
* Time complexity: ?
* DFS
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public static int[] dx = {0, 1, -1, 0};
    public static int[] dy = {1, 0, 0, -1};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0) {
            return result;
        }
        if (board[0] == null || board[0].length == 0) {
            return result;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        Map<String, Boolean> prefixIsWord = getPrefixSet(words);
        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = true;
                dfs(board, visited, i, j, String.valueOf(board[i][j]), prefixIsWord, wordSet);
                visited[i][j] = false;
            }
        }
        return new ArrayList<String>(wordSet);
    }

    // 统计所有的prefix
    private Map<String, Boolean> getPrefixSet(List<String> words) {
        Map<String, Boolean> prefixIsWord = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String prefix = word.substring(0, i + 1);
                // 每一个单词的每一步都加进去
                if (!prefixIsWord.containsKey(prefix)) {
                    prefixIsWord.put(prefix, false);
                }
            }
            // 只有触及到末尾的单词才设为true
            prefixIsWord.put(word, true);
        }
        return prefixIsWord;
    }

    private void dfs(char[][] board,
                     boolean[][] visited,
                     int x,
                     int y,
                     String word,
                     Map<String, Boolean> prefixIsWord,
                     Set<String> wordSet) {
        // 如果没有单词的prefix是word 那他也不可能组成任何单词
        if (!prefixIsWord.containsKey(word)) {
            return;
        }
        // 看word会不会触及到单词的结尾
        if (prefixIsWord.get(word)) {
            wordSet.add(word);
        }
        // 不return 直接朝别的方向走 因为 可能apple是，apples也是
        for (int i = 0; i < 4; i++) {
            int adjX = x + dx[i];
            int adjY = y + dy[i];

            if (!inside(board, adjX, adjY) || visited[adjX][adjY]) {
                continue;
            }

            visited[adjX][adjY] = true;
            dfs(board, visited, adjX, adjY, word + board[adjX][adjY], prefixIsWord, wordSet);
            visited[adjX][adjY] = false;
        }
    }

    // 查有没有越界
    private boolean inside(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
