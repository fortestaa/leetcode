package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x))
                return new int[] { map.get(target - x) + 1, i + 1 };
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
	
	public int[] twoSum0(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int []result = new int[2]; 
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]) + 1;
				result[1] = i + 1;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}
	
	/*public static void main(String[] args) {
		TwoSum s = new TwoSum();
		int[] numbers = {2, 7, 11, 15};
		int[] result = s.twoSum(numbers, 9);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}*/
}