package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 229	Majority Element II
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 * Hint: How many majority elements could it possibly have?
 */
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)   return res;
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        
        int m1 = nums[0], m2 = 0;
        int c1 = 1, c2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x == m1) {
                c1++;
            } else if (x == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = x;
                c1 = 1;
            } else if (c2 == 0) {
                m2 = x;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0; c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == m1) {
                c1++;
            } else if (nums[i] == m2) {
                c2++;
            }
        }
        if (c1 > nums.length / 3)   res.add(m1);
        if (c2 > nums.length / 3)   res.add(m2);
        return res;
    }
}
// http://blog.csdn.net/xudli/article/details/46784149
// http://blog.csdn.net/booirror/article/details/42738563
// https://en.wikipedia.org/wiki/Boyer–Moore_string_search_algorithm