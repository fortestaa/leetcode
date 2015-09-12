package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46 Permutations
 * https://leetcode.com/problems/permutations/
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)   return res;
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] nums, boolean[] visited, List<Integer> item, List<List<Integer>> res) {
        if (item.size() == nums.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                item.add(nums[i]);
                visited[i] = true;
                helper(nums, visited, item, res);
                item.remove(item.size() - 1);
                visited[i] = false;
            }
        }
    }
}
// http://www.cnblogs.com/springfor/p/3888044.html
// http://blog.csdn.net/linhuanmars/article/details/21569031