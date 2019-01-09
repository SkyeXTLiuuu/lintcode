/**
* Wildcard Matching
* Implement wildcard pattern matching with support for '?' and '*'.
* Time complexity: O(mn) 因为每次fill一个array的格子 一共有 mn个
* DFS + DP
*/

public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return isMatch(s, 0, p, 0, memo, visited);
    }

    public boolean isMatch(String s, int sIndex, String p, int pIndex, boolean[][] memo, boolean[][] visited) {
        // 如果 p 从pIdex开始是空字符串了，那么 s 也必须从 sIndex 是空才能匹配上
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        // 如果 s 从 sIndex 是空，那么p 必须全是 *
        if (sIndex == s.length()) {
            return allStar(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;

        if (pChar == '*') {
            match = isMatch(s, sIndex + 1, p, pIndex, memo, visited) || isMatch(s, sIndex, p, pIndex + 1, memo, visited);
        }
        else {
            match = charMatch(sChar, pChar) && isMatch(s, sIndex + 1, p, pIndex + 1, memo, visited);
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;

        return match;
    }

    private boolean charMatch(char sChar, char pChar) {
        return sChar == pChar || pChar == '?';
    }

    private boolean allStar(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i ++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
