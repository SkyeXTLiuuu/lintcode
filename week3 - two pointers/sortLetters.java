/**
* Sort Letters by Case
* Sort a string which contains only letters by lower case first and upper case second.
* Time complexity: O(n)
*/

public class Solution {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        if (chars == null || chars.length == 0) {
            return ;
        }
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && Character.isLowerCase(chars[left])) {
                left ++;
            }
            while (left < right && Character.isUpperCase(chars[right])) {
                right --;
            }
            if (left < right) {
                swap(chars, left, right);
                left ++;
                right --;
            }
        }
    }

    public void swap(char[] chars, int start, int end) {
        char tmp = chars[start];
        chars[start] = chars[end];
        chars[end] = tmp;
    }
}
