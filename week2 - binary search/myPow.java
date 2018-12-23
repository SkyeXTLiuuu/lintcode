/**
* Pow(x, n)
* Implement pow(x, n).
* Time complexity: O(logn)
*/

public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        double ans = 1;
        double tmp = x;
        while (n != 0) {
            if (n >= 0 && n % 2 == 1) {
                ans = ans * tmp;
            }
            else if (n < 0 && n * (-1) % 2 == 1) {
                ans = ans / tmp;
            }
            tmp = tmp * tmp;
            n = n / 2;
        }
        return ans;
    }
}
