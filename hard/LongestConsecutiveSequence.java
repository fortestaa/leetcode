package hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 128	Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example, 
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)   return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        for (int e : nums) {
            set.add(e);
        }
        
        int max = 1;
        for (int e : nums) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;
            
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
// After an element is checked, it should be removed from the set. Otherwise, time complexity would be O(mn) in which m is the average length of all consecutive sequences.
// http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
// http://www.cnblogs.com/springfor/p/3869981.html