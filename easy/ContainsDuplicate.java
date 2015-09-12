package easy;

import java.util.HashMap;

/**
 * 217	Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))   return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
