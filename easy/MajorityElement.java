package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 169	Majority Element
 * https://leetcode.com/problems/majority-element/
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int minSize = num.length / 2;
        if (num.length == 1)    return num[0];
		for (int i = 0; i < num.length; i++) {
			if (count.containsKey(num[i]))  {
			    int c = count.get(num[i]);
			    c += 1;
			    if (c > minSize)
			        return num[i];
				count.put(num[i], c);
			} else {
				count.put(num[i], 1);
			}
		}
		return -1;
    }
}