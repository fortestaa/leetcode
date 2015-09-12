package medium;

/**
 * 121	Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int minElement = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - minElement);
			minElement = Math.min(minElement, prices[i]);
		}
		return profit;
    }
	//http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
	
    /**
     * Submission Result: Time Limit Exceeded
     */
    public int maxProfit0(int[] prices) {
        int max = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
        	for (int j = i; j < len; j++) {
        		int dif = prices[j] - prices[i];
        		if (dif > max)
        			max = dif;
        	}
        }
        return max;
    }
}
