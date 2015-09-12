package easy;

/**
 * 27 Remove Element
 * https://leetcode.com/problems/remove-element/
 * 
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)   return 0;
        int i = 0, j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }
        }
        return j;
    }
}