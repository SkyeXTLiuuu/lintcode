/**
* Similar RGB Color
* Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ")
* Math
*/

public class Solution {
    /**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    public String similarRGB(String color) {
        // Write your code here
        if (color == null || color.length() == 0) {
            return "";
        }

        String result = "#";
        for (int i = 1; i < color.length(); i += 2) {
            result = result + getShortHand(color.substring(i, i + 2));
        }

        return result;
    }

    public String getShortHand(String s) {
        int c = Integer.parseInt(s, 16); // change it from hex to normal number
        if (c % 17 > 8) {
            c = c / 17 + 1;
        }
        else {
            c = c / 17;
        }
        return String.format("%02x", c * 17);
    }
}
