package medium;

/**
 * 137	Single Number II
 * https://leetcode.com/problems/single-number-ii/
 * 
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int[] bitnum = new int[32];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                bitnum[i] += (nums[j] >> i) & 1;
            }
            res |= (bitnum[i] % 3) << i;
        }
        return res;
    }
}
// http://blog.csdn.net/jiadebin890724/article/details/23306837