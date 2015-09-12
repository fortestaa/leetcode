package medium;

/**
 * 64 Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0)
			return 0;
		int len1 = grid.length;
		int len2 = grid[0].length;
		int[][] result = new int[len1][len2];
		result[0][0] = grid[0][0];
		for (int i = 1; i < len1; i++) {
			result[i][0] = result[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < len2; j++) {
			result[0][j] = result[0][j - 1] + grid[0][j];
		}
		
		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				result[i][j] = grid[i][j] + Math.min(result[i - 1][j], result[i][j - 1]);
			}
		}
		
        return result[len1 - 1][len2 - 1];
    }
    
    public static void main(String[] args) {
    	MinimumPathSum s = new MinimumPathSum();
    	int[][] grid = {{1, 2}, {1, 1}};
    	System.out.println(s.minPathSum(grid));
    }
}
// http://joycelearning.blogspot.com/2013/10/leetcode-minimum-path-sum.html
// Java二维数组的声明、初始化和引用 http://www.weixueyuan.net/view/5966.html