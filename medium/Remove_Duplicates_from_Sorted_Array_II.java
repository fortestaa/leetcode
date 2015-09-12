package medium;

/**
 * 80 Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * 
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
 * It doesn't matter what you leave beyond the new length.
 */
public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                count++;
                if (count >= 3) continue;
            } else {
                count = 1;
            }
            nums[idx++] = nums[i];
        }
        return idx;
    }
    
    public static void main(String[] args) {
    	Remove_Duplicates_from_Sorted_Array_II s = new Remove_Duplicates_from_Sorted_Array_II();
    	int[] nums = {1,1,1,2,2,3};
    	System.out.println(s.removeDuplicates(nums));
    }
}
// http://blog.csdn.net/linhuanmars/article/details/24343525
// http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-ii-java/