package medium;

/**
 * 73	Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int[] isxZero = new int[matrix.length];
		int[] isyZero = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
			isxZero[i] = 1;
		for (int j = 0; j < matrix[0].length; j++) {
			isyZero[j] = 1;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					isxZero[i] = 0;
					isyZero[j] = 0;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (isxZero[i] * isyZero[j] == 0)
					matrix[i][j] = 0;
			}
		}
	}
}
