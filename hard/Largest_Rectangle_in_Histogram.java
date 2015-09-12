package hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * 84 Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example, Given height = [2,1,5,6,2,3], return 10.
 */
public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
        }
        return maxArea;
    }
    // 每次都算以一个bar为最低处的rectangle的面积，其中需要知道这个bar左边和右边的两个边界
    // 循环里i为右边边界，stack的top值即为每次取得的最低bar的h值
    // 左边边界：h值比此处h值小，stack.isEmpty() ? 0 : stack.peek()
    // 右边边界：h值比此处h值小，即为i
    // 注意i++的条件，不是任何时候都会i++的——当i为右边界时不需要移动，因为在算得以stack顶bar为谷底的矩形面积的最大值后需要继续将这个i和stack里其他元素比较
    
    // http://www.geeksforgeeks.org/largest-rectangle-under-histogram/	——非常清晰巧妙的解法，讲解很到位，要耐心搞懂才行
    // http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html	——其实感觉还是丈二和尚摸不着头脑，不过评论里看到了geeksforgeeks链接还不错
    
    public static void main(String[] args) {
    	Largest_Rectangle_in_Histogram s = new Largest_Rectangle_in_Histogram();
    	int height[] = {1, 1};
    	System.out.println(s.largestRectangleArea(height));
    }
    
	// Time Limit Exceeded
    public int largestRectangleArea0(int[] height) {
    	if (height == null || height.length <= 0)	return 0;
    	
    	int maxArea = 0;
    	for (int i = 0; i < height.length; i++) {
    		int minHeight = height[i];
    		for (int j = i; j < height.length; j++) {
    			if (height[j] < minHeight) {
    				minHeight = height[j];
    			}
    			int tempArea = minHeight * (j - i + 1);
    			if (tempArea > maxArea) {
    				maxArea = tempArea;
    			}
    		}
    	}
    	return maxArea;
    }
}
// http://www.cnblogs.com/avril/archive/2013/08/24/3278873.html
// http://www.cnblogs.com/avril/archive/2013/08/24/3278873.html
// http://blog.csdn.net/beiyetengqing/article/details/8258232
// 都参考过，奈何不懂