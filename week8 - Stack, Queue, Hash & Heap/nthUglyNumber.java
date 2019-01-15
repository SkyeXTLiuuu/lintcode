/**
* nthUglyNumber
* Ugly number is a number that only have factors 2, 3 and 5
* HashMap + heap
* Time complexity: O(nlogn) 
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        Queue<Long> Q = new PriorityQueue<Long>();
        HashSet<Long> inQ = new HashSet<Long>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);

        for (int i = 0; i < 3; i ++) {
            Q.add(primes[i]);
            inQ.add(primes[i]);
        }

        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i ++) {
            number = Q.poll();
            for (int j = 0; j < 3; j ++) {
                // e.g. 3 x 5 and 5 x 3
                if (!inQ.contains(primes[j] * number)) {
                    Q.add(primes[j] * number);
                    inQ.add(primes[j] * number);
                }
            }
        }
        return number.intValue();
    }
}
