package medium;

/**
 * 240	Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * For example, Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int num = 0;
        int i = 0, j = 0;
        while (i < matrix.length && j < matrix[0].length) {
        	num = matrix[i][j];
        	if (num == target)	return true;
        	if (num > target || j + 1 >= matrix[0].length) {
        		i++;
        		j = 0;
        	} else {
        		j++;
        	}
        }
        return false;
    }

    public boolean searchMatrix0(int[][] matrix, int target) {
    	int num = 0;
        int i = 0, j = 0;
        while (i < matrix.length && j < matrix[0].length) {
        	num = matrix[i][j];
        	if (num == target)	return true;
        	if (num < target) {
        		if (j + 1 < matrix[0].length) {
        			j++;
        		} else {
        			j = 0;
        			i++;
        		}
        	} else {
        		j = 0;
        		i++;
        	}
        }
        return false;
    }

    public static void main(String[] args) {
    	Search2DMatrix2 s = new Search2DMatrix2();
    	/*int[][] matrix = new int[5][5];
    	matrix[0] = new int[]{1,   4,  7, 11, 15};
    	matrix[1] = new int[]{2,   5,  8, 12, 19};
    	matrix[2] = new int[]{3,   6,  9, 16, 22};
    	matrix[3] = new int[]{10, 13, 14, 17, 24};
    	matrix[4] = new int[]{18, 21, 23, 26, 30};
    	System.out.println(s.searchMatrix(matrix, 5));
    	System.out.println(s.searchMatrix(matrix, 20));*/
    	
    	int[][] m = new int[2][1];
    	m[0] = new int[]{5};
    	m[1] = new int[]{6};
    	System.out.println(s.searchMatrix(m, 6));
    }
}