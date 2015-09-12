package hard;

/**
 * 188	Best Time to Buy and Sell Stock IV
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Best_Time_to_Buy_and_Sell_Stock4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k <= 0 || n == 0)   return 0;
        
        if (k >= n / 2) {
            int result = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
        
        int[][] localProfit = new int[n][k + 1];
        int[][] globalProfit = new int[n][k + 1];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < n; i++) {
                localProfit[i][j] = Math.max(localProfit[i - 1][j] + prices[i] - prices[i - 1], globalProfit[i - 1][j - 1] + Math.max(0, prices[i] - prices[i - 1]));
                globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i - 1][j]);
            }
        }
        return globalProfit[n - 1][k];
    }
}
// http://blog.csdn.net/feliciafay/article/details/45128771