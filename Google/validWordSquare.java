/**
* Valid Word Square
* Given a sequence of words, check whether it forms a valid word square.
* example: Given
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]
return true

*/

public class Solution {
    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        // Write your code here
        if (words == null || words.length == 0) {
            return true;
        }

        if (words.length != words[0].length()) {
            return false;
        }

        for (int i = 0; i < words.length; i ++) {
            for (int j = i + 1; j < words[0].length(); j ++) {
                if (words[i].charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
