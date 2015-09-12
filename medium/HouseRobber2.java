package medium;

/**
 * 213	House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * Note: This is an extension of House Robber.
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        if (nums.length == 1)   return nums[0];
        if (nums.length == 2)   return Math.max(nums[0], nums[1]);
        return Math.max(robsub(nums, 0, nums.length - 2), robsub(nums, 1, nums.length - 1));
    }
    
    private int robsub(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] d = new int[len];
        d[0] = nums[start];
        d[1] = Math.max(nums[start], nums[start + 1]);
        
        for (int i = 2; i < len; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + nums[start + i]);
        }
        return d[len - 1];
    }
}
// http://blog.csdn.net/xudli/article/details/45886721