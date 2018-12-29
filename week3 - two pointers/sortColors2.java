/**
* Sort Colors II
* Given an array of n objects with k different colors (numbered from 1 to k)
* sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
* Time complexity: O(nlogk)
*/

public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return ;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    public void rainbowSort(int[] colors, int start, int end, int colorFrom, int colorTo) {
        if (colorFrom == colorTo || start >= end) {
            return ;
        }
        int left = start;
        int right = end;
        int pivot = (colorTo + colorFrom) / 2;
        while(left <= right){
            while(left <= right && colors[left] <= pivot){
                left ++;
            }
            while(left <= right && colors[right] > pivot){
                right --;
            }
            if(left <= right){
                swap(colors, left, right);
                left ++;
                right --;
            }
        }
        rainbowSort(colors, start, right, 1, pivot);
        rainbowSort(colors, left, end, pivot + 1, colorTo);
    }

    public void swap(int[] A, int left, int right){
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}
