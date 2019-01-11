/**
* Permutation Index II
* Given a permutation which may contain repeated numbers,
* find its index in all the permutations of these numbers, which are ordered in lexicographical order.
* Time complexity: O(n^2)
* iteration
*/

public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndexII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        long ans = 1;
        long multi = 1, permutation = 1;

        for (int i = A.length - 1; i >= 0; i --) {
            // i 后重复数字的个数，计算i位时要除以 multi
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
                multi *= map.get(A[i]); // 1*2*3 => 3! => 2!*3!
            }
            else {
                map.put(A[i], 1);
            }

            // i 后有几个比他小的
            int rank = 0;
            for (int j = i + 1; j < A.length; j ++) {
                if (A[j] < A[i]) {
                    rank ++;
                }
            }

            ans += permutation * rank / multi;
            permutation *= A.length - i;
        }

        return ans;
    }
}
