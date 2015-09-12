package easy;

/**
 * 189	Rotate Array
 * https://leetcode.com/problems/rotate-array/
 * 
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * [show hint]
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        if (k >= size)  k = k % size;
        int[] result = new int[size];
        for (int i = 0; i < k; i++) {
        	result[i] = nums[size - k + i];
        }
        for (int i = k; i < size; i++) {
        	result[i] = nums[i - k];
        }
        for (int i = 0; i < size; i++) {
        	nums[i] = result[i];
        }
    }
}