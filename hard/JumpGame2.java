package hard;

/**
 * 45 Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGame2 {
	public int jump(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int maxcover = 0;
		int step = 0;
		int lastcover = 0;
		for (int i = 0; i <= maxcover && i < nums.length; i++) {
			if (i > lastcover) {
				step++;
				lastcover = maxcover;
			}

			if (nums[i] + i > maxcover) {
				maxcover = nums[i] + i;
			}
		}

		if (maxcover < nums.length - 1)
			return 0;
		return step;
	}
}
// http://www.cnblogs.com/springfor/p/3872323.html?utm_source=tuicool
// http://blog.csdn.net/linxiang0591/article/details/38751101