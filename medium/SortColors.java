package medium;

/**
 * 75 Sort Colors
 * https://leetcode.com/problems/sort-colors/
 * 
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
	//ok
    public void sortColors0(int[] nums) {
        int c0 = 0, c1 = 0, c2 = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
        	if (nums[i] == 0)
        		c0++;
        	else if (nums[i] == 1)
        		c1++;
        	else if (nums[i] == 2)
        		c2++;
        }
        for (int i = 0; i < len; i++) {
        	if (c0 != 0) {
        		nums[i] = 0;
        		c0--;
        	} else if (c1 != 0) {
        		nums[i] = 1;
        		c1--;
        	} else if (c2 != 0) {
        		nums[i] = 2;
        		c2--;
        	}
        }
    }
    
    public void sortColors(int[] nums) {
        int len = nums.length;
        int zeroPos = 0, onePos = 0, twoPos = 0;
        for (int i = 0; i < len; i++) {
        	if (nums[i] == 0) {
        		nums[twoPos] = 2;
        		nums[onePos] = 1;
        		nums[zeroPos] = 0;
        		zeroPos++;
        		onePos++;
        		twoPos++;
        	} else if (nums[i] == 1) {
        		nums[twoPos] = 2;
        		nums[onePos] = 1;
        		onePos++;
        		twoPos++;
        	} else if (nums[i] == 2) {
        		nums[twoPos] = 2;
        		twoPos++;
        	}
        }
    }
    // The complexity is O(n).
}
// http://www.lifeincode.net/programming/leetcode-sort-colors-java/