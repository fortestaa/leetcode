package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 149	Max Points on a Line
 * https://leetcode.com/problems/max-points-on-a-line/
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class Max_Points_on_a_Line {
    public int maxPoints(Point[] points) {
        if (points.length < 3)  return points.length;
        
        int max = 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int duplicate = 1;
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                double slope = 0.0;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate++;
                    continue;
                } else if (points[i].x == points[j].x) {
                    slope = Integer.MAX_VALUE;
                } else {
                    slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
                }
                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
            }
            
            if (map.keySet().size() == 0) {
                max = Math.max(duplicate, max);
            } else {
                for (double key : map.keySet()) {
                    max = Math.max(map.get(key) + duplicate, max);
                }
            }
        }
        return max;
    }

	/**
	 * Definition for a point.
	 */
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
}
// http://blog.csdn.net/ljiabin/article/details/38904757