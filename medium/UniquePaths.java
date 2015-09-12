package medium;

/**
 * 62 Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)   return 0;
        if (m == 1 || n == 1)   return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
// http://www.cnblogs.com/springfor/p/3886603.html
/*
 * （dp[i][j]表示到坐标（i,j）的走法数量）：
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */