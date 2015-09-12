package hard;

/**
 * 41 First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, 
 * Given [1,2,0] return 3, 
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1)    return 1;
        int n = nums.length;
        
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] - 1 < n && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return n + 1;
    }
    // http://blog.csdn.net/nanjunxiao/article/details/12973173
}
// http://blog.csdn.net/sbitswc/article/details/31870975