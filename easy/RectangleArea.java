package easy;

/**
 * 223	Rectangle Area
 * https://leetcode.com/problems/rectangle-area/
 * 
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int res = (C - A) * (D - B) + (G - E) * (H - F);
    	int A1 = Math.max(A, E), B1 = Math.max(B, F), C1 = Math.min(C, G), D1 = Math.min(D, H);
    	if (C1 <= A1 || D1 <= B1)	return res;
    	return res - (C1 - A1) * (D1 - B1);
    }
}
//http://www.cnblogs.com/easonliu/p/4560596.html