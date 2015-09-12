package medium;

/**
 * 221	Maximal Square
 * https://leetcode.com/problems/maximal-square/
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] d = new int[m][n];
		int max = 0;

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1') {
				d[i][0] = 1;
				max = 1;
			}
		}

		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == '1') {
				d[0][j] = 1;
				max = 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '0') {
					d[i][j] = 0;
				} else {
					d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]),
							d[i - 1][j - 1]) + 1;
					max = Math.max(max, d[i][j]);
				}
			}
		}

		return max * max;
	}
}
//http://blog.csdn.net/xudli/article/details/46371673