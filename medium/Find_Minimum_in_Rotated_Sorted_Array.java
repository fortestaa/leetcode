package medium;

/**
 * 153 Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] num) {
        int L = 0, R = num.length - 1;
        while (L < R && num[L] >= num[R]) {
            int M = (L + R) / 2;
            if (num[M] > num[R]) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return num[L];
    }
}