/**
* Split String
* You can choose to split the string after one character or two adjacent characters,
* and make the string to be composed of only one character or two characters. Output all possible results.
* Time complexity: O（2 ^ n) 
* DFS
*/

public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (s == null) {
            return results;
        }
        List<String> local = new ArrayList<String>();
        dfs(s, 0, local, results);
        return results;
    }

    public void dfs(String s, int index, List<String> local, List<List<String>> results) {
        if (index >= s.length()) {
            results.add(new ArrayList<String>(local));
            return ;
        }

        if (index + 1 <= s.length()) {
            local.add(s.substring(index, index + 1));
            dfs(s, index + 1, local, results);
            local.remove(local.size() - 1);
        }

        if (index + 2 <= s.length()) {
            local.add(s.substring(index, index + 2));
            dfs(s, index + 2, local, results);
            local.remove(local.size() - 1);
        }
    }
}
