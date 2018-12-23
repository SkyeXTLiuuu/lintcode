/**
* Smallest Rectangle Enclosing Black Pixels
* Given the location (x, y) of one of the black pixels, return the area of the smallest rectangle that encloses all black pixels.
* Time complexity: O(logn + logm)
*/

public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int m = image.length;
        int n = image[0].length;
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, n - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, m - 1);
        return (bottom - top + 1) * (right - left + 1);
    }

    public int findLeft(char[][] image, int start, int end){
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (isEmptyCol(image, mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        // 如果start这排是空的，那么从end那一排开始算
        if (isEmptyCol(image, start)) {
            return end;
        }
        return start;
    }

    public int findRight(char[][] image, int start, int end){
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (isEmptyCol(image, mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (isEmptyCol(image, end)) {
            return start;
        }
        return end;
    }

    public int findTop(char[][] image, int start, int end){
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (isEmptyRow(image, mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (isEmptyRow(image, start)) {
            return end;
        }
        return start;
    }

    public int findBottom(char[][] image, int start, int end){
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (isEmptyRow(image, mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (isEmptyRow(image, end)) {
            return start;
        }
        return end;
    }

    public boolean isEmptyRow(char[][] image, int row){
        for (int i = 0; i < image[row].length; i ++) {
            if(image[row][i] != '0') {
                return false;
            }
        }
        return true;
    }

    public boolean isEmptyCol(char[][] image, int col){
        for (int i = 0; i < image.length; i ++) {
            if(image[i][col] != '0') {
                return false;
            }
        }
        return true;
    }
}
