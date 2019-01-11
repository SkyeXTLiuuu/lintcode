/**
* String Permutation II
* Given a string, find all permutations of it without duplicates.
* Time complexity: O(n! * n) ??
* DFS
*/

public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (str == null) {
            return results;
        }
        char[] word = str.toCharArray();
        Arrays.sort(word);
        dfs(word, new boolean[str.length()], "", results);
        return results;
    }

    public void dfs(char[] word,
                    boolean[] visited,
                    String permutation,
                    List<String> results) {
        if (permutation.length() == word.length) {
            results.add(permutation);
            return ;
        }

        for (int i = 0; i < word.length; i ++) {
            if (visited[i]) {
                continue;
            }
            if (i != 0 && word[i - 1] == word[i] && visited[i - 1] == false) {
                continue;
            }

            permutation += word[i];
            visited[i] = true;
            dfs(word, visited, permutation, results);
            permutation = permutation.substring(0, permutation.length() - 1);
            visited[i] = false;
        }
    }
}
