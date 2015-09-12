package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 218	The Skyline Problem
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        
        List<int[]> b1 = new ArrayList<int[]>();
        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            b1.add(new int[]{b[0], b[2]});
            b1.add(new int[]{b[1], -b[2]});
        }
        Collections.sort(b1, new Comparator<int[]>() {
           @Override
           public int compare(int[] a, int[] b) {
               if (a[0] != b[0])    return a[0] - b[0];
               else return b[1] - a[1];
           }
        });
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int pre = 0, cur = 0;
        for (int i = 0; i < b1.size(); i++) {
            int[] b = b1.get(i);
            if (b[1] > 0) {
                maxHeap.add(b[1]);
                cur = maxHeap.peek();
            } else {
                maxHeap.remove(-b[1]);
                cur = (maxHeap.peek() == null) ? 0 : maxHeap.peek();
            }
            if (cur != pre) {
                res.add(new int[]{b[0], cur});
                pre = cur;
            }
        }
        
        return res;
    }
}
// http://blog.csdn.net/xudli/article/details/46349383 代码
// http://www.cnblogs.com/TinyBobo/p/4592061.html 思路
//http://blog.csdn.net/balonfan/article/details/5135714