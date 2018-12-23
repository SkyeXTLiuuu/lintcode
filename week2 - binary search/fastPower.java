/**
* Fast Power
* Calculate the a^n % b where a, b and n are all 32bit positive integers.
* Time complexity: O(logn)
*/

public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        long ans = 1;
        long tmp = a;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = (ans * tmp) % b;
            }
            tmp = tmp * tmp % b;
            n = n / 2;
        }
        return (int) ans % b;
    }
}
