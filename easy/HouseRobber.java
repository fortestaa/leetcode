package easy;

/**
 * 198	House Robber
 * https://leetcode.com/problems/house-robber/
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] d = new int[n];
        
        if (nums == null || n == 0)	return 0;
        if (n == 1)	return nums[0];
        
        d[0] = nums[0];
        d[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
        	d[i] = Math.max(d[i - 1], d[i - 2] + nums[i]);
        }
        
        return d[n - 1];
    }
}