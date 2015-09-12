package hard;

/**
 * 123	Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Best_Time_to_Buy_and_Sell_Stock3 {
    /**
     * divide and conquer
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
        	return 0;
        }
        
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
        	min = Math.min(min, prices[i]);
        	left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
        	max = Math.max(max, prices[i]);
        	right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
        	profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
}