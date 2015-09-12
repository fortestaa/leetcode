package medium;

/**
 * 209 Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, 
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * More practice: If you have figured out the O(n) solution, 
 * try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
    	if (nums == null || nums.length == 0)	return 0;
    	int res = Integer.MAX_VALUE;
    	int sum = 0, i = 0, j = 0;
    	while (i <= j && j < nums.length && sum < s) {
    		sum += nums[j];
    		while (i <= j && sum >= s) {
    			res = Math.min(res, j - i + 1);
    			sum -= nums[i];
    			i++;
    		}
    		j++;
    	}
    	return (res == Integer.MAX_VALUE ? 0 : res);
    }
    // http://blog.csdn.net/litoupu/article/details/45667863
	
	// Time Limit Exceeded
    public int minSubArrayLen1(int s, int[] nums) {
    	int rst = Integer.MAX_VALUE;
    	int tmpSum;
        for (int i = 0; i < nums.length; i++) {
        	tmpSum = 0;
        	for (int j = i; j < nums.length; j++) {
        		tmpSum += nums[j];
        		if (tmpSum >= s) {
        			int cnt = j - i + 1;
        			rst = cnt < rst ? cnt : rst;
        		}
        	}
        }
        return rst;
    }
    
    public static void main(String[] args) {
    	MinimumSizeSubarraySum sol = new MinimumSizeSubarraySum();
    	int nums[] = { 1, 4, 4 };
    	int s = 4;
    	System.out.println(sol.minSubArrayLen(s, nums));
    }
}