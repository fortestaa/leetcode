package medium;

/**
 * 81	Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class Search_in_RotatedSortedArray2 {
	public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)   return false;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                if (nums[mid] < nums[hi]) {	// right side is sorted
                    hi = mid - 1;	// target must in left side
                } else if (nums[mid] == nums[hi]) {	// cannot tell right is sorted
                    hi--;
                } else {	// left side is sorted
                    if (target < nums[lo]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            } else if (target > nums[mid]) {
                if (nums[mid] > nums[lo]) {	// left side is sorted
                    lo = mid + 1;
                } else if (nums[mid] == nums[lo]) {	// cannot tell left is sorted
                    lo++;
                } else {	//right side is sorted
                    if (target > nums[hi]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}
//http://blog.csdn.net/linhuanmars/article/details/24446871