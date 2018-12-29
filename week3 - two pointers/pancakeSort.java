public class Solution {
    /**
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        // Write your code here
        if (array == null || array.length == 0) {
            return ;
        }
        pancakeSort(array, array.length - 1);
    }

    public void pancakeSort(int[] array, int end) {
        if (end == 0) {
            return ;
        }
        int max = 0;
        for (int i = 0; i <= end; i ++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        FlipTool.flip(array, max);
        FlipTool.flip(array, end);
        pancakeSort(array, end - 1);
    }
}
