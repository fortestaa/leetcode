package hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * 85	Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
    
    private int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        int i = 0;
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
}
// 用上largestRectangleArea题目的解法
// 维持一个height数组，用来存储每列的高度（高度值随着行数的扫描会有所变化）
// 对于char数组，逐行来看：
// 	如果某一列j是'0‘那么height[j]会变为0，否则加一
//	每行结束后计算一下目前为止可以得到的最大值（the largest rectangle containing all ones）或者（largestRectangleArea） 
// http://www.cnblogs.com/springfor/p/3869492.html