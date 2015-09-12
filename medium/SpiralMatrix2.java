package medium;

/**
 * 59 Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: 
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ], 
 *  [ 7, 6, 5 ] 
 * ]
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int k = 1;
        while (left < right && top < bottom) {
            for (int j = left; j < right; j++) {
                res[top][j] = k++;
            }
            for (int i = top; i < bottom; i++) {
                res[i][right] = k++;
            }
            for (int j = right; j > left; j--) {
                res[bottom][j] = k++;
            }
            for (int i = bottom; i > top; i--) {
                res[i][left] = k++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (n % 2 == 1) res[n / 2][n / 2] = k++;
        return res;
    }
}
// https://leetcodenotes.wordpress.com/2013/11/23/leetcode-spiral-matrix-把一个2d-matrix用螺旋方式打印/