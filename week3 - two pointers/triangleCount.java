/**
* Triangle Count
* Count how many tree edges these numbers can form
* Time complexity: O(n^2)
*/

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        if (S == null || S.length == 0) {
            return 0;
        }
        int left = 0, right = S.length - 1;
        Arrays.sort(S);
        int count = 0;
        for (int i = 0; i < S.length; i ++) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    // 从left到right中间所有数加上right都满足条件
                    count += right - left;
                    //right向前移，变成所有right左边的和现在的right比较
                    right --;
                }
                else {
                    left ++;
                }
            }
        }
        return count;
    }
}
