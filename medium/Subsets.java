package medium;

import java.util.*;

/**
 * 78 Subsets
 * https://leetcode.com/problems/subsets/
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets. 
 * 
 * For example, If nums = [1,2,3], a solution is:
 * 
 * [
 *  [3], 
 *  [1], 
 *  [2], 
 *  [1,2,3], 
 *  [1,3], 
 *  [2,3], 
 *  [1,2], 
 *  [] 
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)	return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
        	List<List<Integer>> tmp = new ArrayList<List<Integer>>();
    		// get sets that are already in result
        	for (List<Integer> a : result) {
        		tmp.add(new ArrayList<Integer>(a));
        	}
    		//add nums[i] to existing sets
        	for (List<Integer> a : tmp) {
        		a.add(nums[i]);
        	}
    		//add nums[i] only as a set
        	List<Integer> single = new ArrayList<Integer>();
        	single.add(nums[i]);
        	tmp.add(single);
        	result.addAll(tmp);
        }
    	//add empty set
        result.add(new ArrayList<Integer>());
        return result;
    }
    //http://www.programcreek.com/2013/01/leetcode-subsets-java/
}