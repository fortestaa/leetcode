package medium;

/**
 * 122	Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Best_Time_to_Buy_and_Sell_Stock2 {
	public int maxProfit(int[] prices) {
		int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
	}
	//http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-ii-java/
}