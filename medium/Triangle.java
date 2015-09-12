package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120	Triangle
 * https://leetcode.com/problems/triangle/
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int size = triangle.size();
		if (size == 1)	return triangle.get(0).get(0);
		int[] dp = new int[size];
		
		for (int i = 0; i < triangle.get(size - 1).size(); i++) {
			dp[i] = triangle.get(size - 1).get(i);
		}
		
		for (int i = size - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		Triangle s = new Triangle();
		// List<List<Integer>> t = new ArrayList<List<Integer>>([[2], [3,4],
		// [6,5,7], [4,1,8,3]]);
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		System.out.println(s.minimumTotal(triangle));

		List<List<Integer>> t = new ArrayList<List<Integer>>();
		t.add(Arrays.asList(-1));
		t.add(Arrays.asList(-2, -3));
		System.out.println(s.minimumTotal(t));
	}
}
// http://www.cnblogs.com/springfor/p/3887908.html
// Java笔记 – 数组 一维数组 多维数组 数组与泛型 数组实用功能
// http://www.itzhai.com/java-bi-ji-shu-zu-yi-wei-shu-zu-duo-wei-shu-zu-shu-zu-yu-fan-xing-shu-zu-shi-yong-gong-neng.html