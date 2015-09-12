package easy;

/**
 * 231	Power of Two
 * https://leetcode.com/problems/power-of-two/
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
    	while (n > 1) {
    		int tmp = n >> 1;
    		int last = n - (tmp << 1);
    		if (last != 0)	return false;
    		n = tmp;
    	}
    	return true;
    }
}
