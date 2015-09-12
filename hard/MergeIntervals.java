package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56 Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        
        int n = intervals.size();
        Interval[] array = intervals.toArray(new Interval[n]);
        Arrays.sort(array, new Comparator<Interval>() {
           @Override
           public int compare(Interval i1, Interval i2) {
               return i1.start - i2.start;
           }
        });
        
        List<Interval> res = new ArrayList<Interval>();
        Interval mover = array[0];
        for (int i = 1; i < n; i++) {
            if (mover.end < array[i].start) {
                res.add(mover);
                mover = array[i];
            } else {
                mover.end = Math.max(mover.end, array[i].end);
            }
        }
        res.add(mover);
        return res;
    }
    
    /**
     * Definition for an interval.
     */
    public class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }
}
// http://www.tuicool.com/articles/63Yryy