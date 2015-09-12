package medium;

/**
 * 74 Search a 2D Matrix
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 	Integers in each row are sorted from left to right. 
 * 	The first integer of each row is greater than the last integer of the previous row. 
 * 
 * For example,
 * Consider the following matrix:
 * [
 *  [1, 3, 5, 7], 
 *  [10, 11, 16, 20], 
 *  [23, 30, 34, 50]
 * ] 
 * Given target = 3, return true.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int len1 = matrix.length;
    	int len2 = matrix[0].length;
        for (int i = 0; i < len1; i++) {
        	int start = 0, end = len2 - 1;
        	if (matrix[i][start] > target)	return false;
        	if (matrix[i][end] < target)	continue;
        	while (start <= end) {
        		int mid = (start + end) / 2;
        		if (matrix[i][mid] == target)	return true;
        		else if (matrix[i][mid] < target)	start++;
        		else	end--;
        	}
        }
        return false;
    }
    
    public static void main(String[] args) {
    	Search2DMatrix s = new Search2DMatrix();
    	int[][] matrix = {
    			{1,   3,  5,  7},
    			{10, 11, 16, 20},
    			{23, 30, 34, 50}
    	};
    	System.out.println(s.searchMatrix(matrix, 3));
    }
}
