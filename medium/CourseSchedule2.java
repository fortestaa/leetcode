package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> adjlists = new ArrayList<Set<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjlists.add(new HashSet<Integer>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            adjlists.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int x : adjlists.get(i)) {
                indegrees[x]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int x : adjlists.get(cur)) {
                indegrees[x]--;
                if (indegrees[x] == 0) {
                    queue.offer(x);
                }
            }
            res[count++] = cur;
        }
        if (count == numCourses)    return res;
        return new int[0];
    }
}
// http://blog.csdn.net/ljiabin/article/details/45847019