package medium;

/**
 * 48 Rotate Image https://leetcode.com/problems/rotate-image/
 * 
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)	return;
		int layerNum = matrix.length / 2;
		for (int layer = 0; layer < layerNum; layer++) {
			for (int i = layer; i < matrix.length - layer - 1; i++) {
				int temp = matrix[layer][i];	//上
				matrix[layer][i] = matrix[matrix.length - 1 - i][layer];	//左->上
				matrix[matrix.length - 1 - i][layer] = matrix[matrix.length - 1 - layer][matrix.length - 1 - i];	//下->左
				matrix[matrix.length - 1 - layer][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - layer];	//右->下
				matrix[i][matrix.length - 1 - layer] = temp;	//上->右
			}
		}
	}
}
/*
 * 这道题虽然操作起来有一点繁琐，但是思路比较简单，就是考察一下数组的基本操作.
 * 基本思路是把图片分为行数/2层，然后一层层进行旋转，每一层有上下左右四个列， 
 * 然后目标就是把上列放到右列，右列放到下列，下列放到左列，左列放回上列，中间保存一个临时变量即可。
 * 因为每个元素搬运的次数不会超过一次，时间复杂度是O(矩阵的大小)，空间复杂度是O(1)。
 */
// http://blog.csdn.net/linhuanmars/article/details/21503683
// http://www.cnblogs.com/springfor/p/3886487.html