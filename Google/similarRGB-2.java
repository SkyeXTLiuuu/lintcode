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
        if (s.charAt(0) == s.charAt(1)) {
            return s;
        }

        char[] intToChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        int i1 = charToInt(s.charAt(0)); // 如果直接是(int)'1' 的话会变成49
        int i2 = charToInt(s.charAt(1));
        int sum = 16 * i1 + i2; // get normal number
        // 如果首位小于第二位，例如37，就在33 和 44里面取，或者ef，就在ee和ff里面取
        if (i1 < i2) {
            // 因为 11，22，AA 这些全都是17的倍数 (a * 16) + a = 17a 所以就当前位数*17就是他的sum
            // i1 的距离比i1 + 1小
            if (Math.abs(sum - i1 * 17) < Math.abs(sum - (i1 + 1) * 17)){
                return "" + intToChar[i1] + intToChar[i1];
            }
            else {
                return "" + intToChar[i1 + 1] + intToChar[i1 + 1];
            }
        }
        else {
            if (Math.abs(sum - i1 * 17) < Math.abs(sum - (i1 - 1) * 17)){
                return "" + intToChar[i1] + intToChar[i1];
            }
            else {
                return "" + intToChar[i1 - 1] + intToChar[i1 - 1];
            }
        }
    }

    public int charToInt(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        return c - 'a' + 10;
    }
}
