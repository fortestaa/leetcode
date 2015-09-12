package medium;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 220	Contains Duplicate III
 * https://leetcode.com/problems/contains-duplicate-iii/
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if ((set.floor(n) != null && n <= t + set.floor(n)) || (set.ceiling(n) != null && set.ceiling(n) <= t + n)) {
                return true;
            }
            set.add(n);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
    //http://www.cnblogs.com/jiajiaxingxing/p/4572871.html

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null || nums.length < 2)	return false;
        
        SortedSet<Long> set = new TreeSet<Long>();
        for (int j = 0; j < nums.length; j++) {
        	SortedSet<Long> subset = set.subSet((long)nums[j] - t, (long)nums[j] + t + 1);
        	if (!subset.isEmpty())	return true;
        	
        	if (j <= k) {
        		set.remove((long)nums[j - k]);
        	}
        	set.add((long)nums[j]);
        }
        return false;
    }
    //http://blog.csdn.net/xudli/article/details/46323247
}
