package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228	Summary Ranges
 * https://leetcode.com/problems/summary-ranges/
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
    	List<String> res = new ArrayList<String>();
    	if (nums == null || nums.length < 1)	return res;
    	
    	int s = 0, e = 0;
    	while (e < nums.length) {
    		if (e + 1 < nums.length && nums[e + 1] == nums[e] + 1) {
    			e++;
    		} else {
    			if (s == e) {
    				res.add(Integer.toString(nums[s]));
    			} else {
    				String str = nums[s] + "->" + nums[e];
    				res.add(str);
    			}
    			++e;
    			s = e;
    		}
    	}
    	return res;
    }
    // http://blog.csdn.net/xudli/article/details/46645087
    // http://www.cnblogs.com/NickyYe/p/4601865.html

    public List<String> summaryRanges0(int[] nums) {
		List<String> rst = new ArrayList<String>();
		if (nums == null || nums.length == 0)
			return rst;

		int start = 0; // start index
		StringBuffer sb = new StringBuffer();
		sb.append(nums[start]);
		int len = nums.length;
		if (len == 1) {
			rst.add(sb.toString());
		}

		for (int i = 1; i < len; i++) {
			if (nums[i] == nums[i - 1] + 1) {
				if (i != len - 1) {
					continue;
				} else {
					sb.append("->" + nums[i]);
					rst.add(sb.toString());
				}
			} else {
				if (i == start + 1) {
					rst.add(sb.toString());
				} else {
					sb.append("->" + nums[i - 1]);
					rst.add(sb.toString());
				}

				sb = new StringBuffer();
				start = i;
				sb.append(nums[start]);
				if (i == len - 1) {
					rst.add(sb.toString());
				}
			}
		}
		return rst;
	}
    
	public static void main(String[] args) {
		SummaryRanges s = new SummaryRanges();
		int nums[] = { 0, 1, 2, 4, 5, 7 };
		System.out.println(s.summaryRanges(nums));

		int test[] = { 0, 1 };
		System.out.println(s.summaryRanges(test));
		
		int t2[] = {1, 3, 4, 6, 7};
		System.out.println(s.summaryRanges(t2));
	}
}
