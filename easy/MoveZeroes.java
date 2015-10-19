/*
283	Move Zeroes
https://leetcode.com/problems/move-zeroes/

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr != 0) {
                nums[cnt++] = curr;
            }
        }
        //int zeros = nums.length - cnt;
        for (int i = cnt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
