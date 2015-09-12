package easy;

import java.util.HashMap;

/**
 * 219	Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and 
 * the difference between i and j is at most k.
 */
public class ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
	
    /**
     * Time Limit Exceeded
     */
    public boolean containsNearbyDuplicate0(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 2)	return false;
        
        int n = nums.length;
        for (int i = 1; i <= k; i++) {
        	for (int j = 0; j < n - i; j++) {
        		if (nums[j] == nums[j + i]) {
        			return true;
        		}
        	}
        }
        return false;
    }
}
//http://blog.csdn.net/ethan_seu/article/details/46446711