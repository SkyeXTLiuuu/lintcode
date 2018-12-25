/**
* Prime Factorization
* Prime factorize a given integer.
* example: 10 => [2, 5] 660 => [2, 2, 3, 5, 11]
* Time complexity: O(sqrt(n)) when n is prime
* Space complexity: O(log(n)) when n has many prime factors
*/

public class Solution {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (num == 0) {
            return result;
        }
        int up = (int) Math.sqrt(num);
        for (int i = 2; i <= up; i ++) {
            while (num % i == 0) {
                result.add(i);
                num = num / i;
            }
        }
        if (num != 1) {
            result.add(num);
        }
        return result;
    }
}
