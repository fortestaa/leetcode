package easy;

/**
 * 172 Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int r = 0;
    	while (n > 0) {
    		n /= 5;
    		r += n;
    	}
    	return r;
    }
}
// http://bookshadow.com/weblog/2014/12/30/leetcode-factorial-trailing-zeroes/