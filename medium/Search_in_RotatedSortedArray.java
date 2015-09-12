package medium;

public class Search_in_RotatedSortedArray {
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)   return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target == nums[mid])    return mid;
            if (nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
}
//http://blog.csdn.net/linhuanmars/article/details/20525681