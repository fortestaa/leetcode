package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47 Permutations II
 * https://leetcode.com/problems/permutations-ii/
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: 
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)   return res;
        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] nums, boolean[] used, List<Integer> item, List<List<Integer>> res) {
        if (item.size() == nums.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])    continue;
            if (!used[i]) {
                used[i] = true;
                item.add(nums[i]);
                helper(nums, used, item, res);
                item.remove(item.size() - 1);
                used[i] = false;
            }
        }
    }
}
// http://blog.csdn.net/linhuanmars/article/details/21570835