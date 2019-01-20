/**
* Twitch Words
* Find out the starting point and ending point of all tics.
* example: Given str = "whaaaaatttsup", return [[2,6],[7,9]].
* Time complexity:
* Space complexity:
*/

public class Solution {
    /**
     * @param str: the origin string
     * @return: the start and end of every twitch words
     */
    public int[][] twitchWords(String str) {
        // Write your code here
        if (str == null || str.length() == 0) {
            return new int[0][0];
        }

        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < str.length(); i ++) {
            int index = i;
            while (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                i ++;
            }
            if (i <= str.length() && i - index > 1) {
                result.add(new int[]{index - 1, i - 1});
            }
        }

        int[][] tics = new int[result.size()][2];
        for (int i = 0; i < result.size(); i ++) {
            tics[i] = result.get(i);
        }

        return tics;
    }
}
