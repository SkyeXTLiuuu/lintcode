/**
* Permutation Index
* Find its index in all the permutations of these numbers, which are ordered in lexicographical order.
* Time complexity: O(n^2)
* iteration
* 找在他之前的有多少数， 然后加上1 就是他的index
* 如果要比他小 就是在i的左边相同，i比现在的i小，右边取全排列
* [3,7,4,9,1] =》[3,7,4,1,X]，[3,7,1,X,X]，[3,1或4,X,X,X]，[1,X,X,X,X]
* 结果就是每一位可能更小的数 *  右边的全排列数
*/

public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long permutation = 1;
        long result = 0;

        for (int i = A.length - 2; i >= 0; i --) {
            int smaller = 0;
            for (int j = i + 1; j < A.length; j ++) {
                if (A[j] < A[i]) {
                    smaller ++;
                }
            }
            result += smaller * permutation;
            permutation *= A.length - i;
        }
        return result + 1;
    }
}
