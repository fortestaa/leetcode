package hard;

/**
 * 42 Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Trapping_Rain_Water {
    public int trap(int[] height) {
        if (height == null || height.length == 0)   return 0;
        
        int res = 0;
        int start = 0;
        int end = height.length - 1;
        int h = Math.min(height[start], height[end]);
        
        while (start < end) {
            if (height[start] < height[end]) {
                res += Math.max(h - height[start + 1], 0);
                h = Math.max(h, Math.min(height[start + 1], height[end]));
                start++;
            } else {
                res += Math.max(h - height[end - 1], 0);
                h = Math.max(h, Math.min(height[start], height[end - 1]));
                end--;
            }
        }
        return res;
    }
}
// http://www.tuicool.com/articles/3qeUja