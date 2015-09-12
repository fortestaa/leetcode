package medium;

/**
 * 34 Search for a Range
 * https://leetcode.com/problems/search-for-a-range/
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */
public class Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0)   return res;
        
        int l = 0;
        int r = nums.length - 1;
        int m = (l + r) / 2;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                res[0] = m;
                res[1] = m;
                break;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (nums[m] != target)  return res;
        
        int newl = m;
        int newr = nums.length - 1;
        while (newl <= newr) {
            int newm = (newl + newr) / 2;
            if (nums[newm] == target) {
                newl = newm + 1;
            } else {
                newr = newm - 1;
            }
        }
        res[1] = newr;
        
        newl = 0;
        newr = m;
        while (newl <= newr) {
            int newm = (newl + newr) / 2;
            if (nums[newm] == target) {
                newr = newm - 1;
            } else {
                newl = newm + 1;
            }
        }
        res[0] = newl;
        
        return res;
    }
}
// http://blog.csdn.net/linhuanmars/article/details/20593391	两次二分查找-待看