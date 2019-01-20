/**
* Flip Game
* Take turns to flip two consecutive "++" into "--", compute all possible states of the string after one valid move.
* example:
*    s = "++++", after one move, it may become one of the following states:
[
  "--++",
  "+--+",
  "++--"
]

*/

public class Solution {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }

        for (int i = 0; i < s.length() - 1; i ++) {
            String cur = s.substring(i, i + 2);
            if (cur.charAt(0) != '+' || cur.charAt(0) != cur.charAt(1)) {
                continue;
            }
            String state = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
            result.add(state);
        }
        return result;
    }
}
