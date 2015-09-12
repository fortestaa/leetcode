package medium;

/**
 * 55 Jump Game
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
        int maxCover = 0;
        for (int start = 0; start <= maxCover && start < nums.length; start++) {
            if (start + nums[start] > maxCover) {
                maxCover = start + nums[start];
            }
            if (maxCover >= nums.length - 1)    return true;
        }
        return false;
    }
}
// http://www.cnblogs.com/springfor/p/3872320.html