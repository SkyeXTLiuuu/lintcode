/**
* Rotate String
* Given a string and an offset, rotate string by offset. (rotate from left to right)
* Time complexity: O(n)
* 三步翻转法 
*/

public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0 || offset <= 0) {
            return ;
        }
        offset = offset % str.length;
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length - 1);
    }

    private void reverse(char[] str, int start, int end){
        while (start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start ++;
            end --;
        }
    }
}
