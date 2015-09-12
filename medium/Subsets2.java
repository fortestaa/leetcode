package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90	Subsets II
 * https://leetcode.com/problems/subsets-ii/
 * 
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Subsets2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        Arrays.sort(nums);
        for (int len = 1; len <= nums.length; len++) {
            dfs(nums, 0, len, item, rst);
        }
        rst.add(new ArrayList<Integer>());
        return rst;
    }
    
    public void dfs(int[] nums, int start, int len, List<Integer> item, List<List<Integer>> rst) {
        if (item.size() == len) {
            if (!rst.contains(item)) {
                rst.add(new ArrayList<Integer>(item));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            dfs(nums, i + 1, len, item, rst);
            item.remove(item.size() - 1);
        }
    }
}
//http://www.cnblogs.com/springfor/p/3879853.html