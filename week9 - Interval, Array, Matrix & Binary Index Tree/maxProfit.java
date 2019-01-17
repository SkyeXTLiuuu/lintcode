/**
* Best Time to Buy and Sell Stock
* If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
* design an algorithm to find the maximum profit.
* Time complexity:
*/

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int num: prices) {
            min = Math.min(min, num);
            profit = Math.max(profit, num - min);
        }
        return profit;
    }
}
