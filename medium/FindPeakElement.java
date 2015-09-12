package medium;

/**
 * 162 Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 * 
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
    public int findPeakElement1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                return i - 1;
        }
        return nums.length - 1;
    }

    public int findPeakElement2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        } else {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] > nums[mid2]) {
                return helper(nums, low, mid1);
            } else {
                return helper(nums, mid2, high);
            }
        }
    }

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                low = mid2;
            } else {
                high = mid1;
            }
        }
        return low;
    }
}
// http://www.cnblogs.com/ganganloveu/p/4147655.html