/**
* Interleaving Positive and Negative Numbers
* Re-range it to interleaving with positive and negative integers.
* Time complexity: O(n)
*/

public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        if(A == null || A.length <= 1){
            return ;
        }
        // move postive to the right, negative to the left
        int left = 0;
        int right = A.length - 1;
        while(left < right){
            while(left < right && A[left] < 0){
                left ++;
            }
            while(left < right && A[right] > 0){
                right --;
            }
            if(left < right){
                swap(A, left, right);
            }
        }

        // interleave
        int negative = left;
        int positive = A.length - left;

        // the numbers are not balanced, move extra numbers to the end of the list
        int diff = Math.abs(negative - positive);
        int min = Math.min(negative, positive);
        if(negative - positive > 0){
            int curDif = diff;
            int l = min;
            int r = A.length - 1;
            while(curDif >= 0){
                swap(A, l, r);
                l ++;
                r --;
                curDif --;
            }
            left = 1;
            right = A.length - diff - 2;
        }
        else{
            left = 0;
            right = A.length - diff - 1;
        }

        // interleaving to the middle
        while(left < min){
            swap(A, left, right);
            left = left + 2;
            right = right - 2;
        }
    }
    public void swap(int[] A, int left, int right){
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}
