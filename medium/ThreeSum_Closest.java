package medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSum_Closest {
	public int threeSumClosest(int[] nums, int target) {
        int rst = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    rst = sum;
                }
                
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return rst;
    }
	
	public static void main(String[] args) {
		ThreeSum_Closest s = new ThreeSum_Closest();
		int nums[] = {1, 1, 1, 0};
		System.out.println(s.threeSumClosest(nums, 100));
	}
}
// http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/