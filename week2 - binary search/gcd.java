/**
* Greatest Common Divisor
* Given two numbers, number a and number b. Find the greatest common divisor of the given two numbers.
* example: a = 10, b = 15 => 5.
* 辗转相除法
* Time complexity: O(n)
*/

public class Solution {
    /**
     * @param a: the given number
     * @param b: another number
     * @return: the greatest common divisor of two numbers
     */
    public int gcd(int a, int b) {
        // write your code here
        int tmp = a;
        a = Math.max(a, b);
        b = Math.min(tmp, b);
        return calculate(a, b);
    }

    private int calculate(int a, int b){
        if (b != 0) {
            return gcd(b, a % b);
        }
        else {
            return a;
        }
    }
}
