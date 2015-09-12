package hard;

/**
 * 164 Maximum Gap 
 * https://leetcode.com/problems/maximum-gap/
 * 
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
	public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)    return 0;
        
        int max = nums[0], min = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }
        
        int[] min_bs = new int[len + 1];
        int[] max_bs = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            int k = (int) (len * (1.0 * (x - min) / (max - min)));
            if (min_bs[k] == 0 || x < min_bs[k])    min_bs[k] = x;
            if (max_bs[k] == 0 || x > max_bs[k])    max_bs[k] = x;
        }
        
        int maxInter = 0;
        min = max_bs[0];
        for (int i = 1; i < len + 1; i++) {
            if (min_bs[i] == 0) continue;
            maxInter = Math.max(maxInter, min_bs[i] - min);
            min = max_bs[i];
        }
        return maxInter;
    }
}
// http://blog.csdn.net/xudli/article/details/42211281