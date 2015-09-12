package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179	Largest Number
 * https://leetcode.com/problems/largest-number/
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        if (n < 1)  return "";
        
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new Cmp());
        
        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
            ans = ans.concat(strs[i]);
        }
        
        int i = 0;
        while (i < n && ans.charAt(i) == '0') {
            i++;
        }
        if (i == n) return "0";
        return ans.substring(i);
    }
    
    class Cmp implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String ab = a.concat(b);
            String ba = b.concat(a);
            return ab.compareTo(ba);
        }
    }
}
//http://blog.csdn.net/ljiabin/article/details/42676433