package easy;

/**
 * 191	Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class Number_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
        	n = n & (n - 1);
        	sum++;
        }
        return sum;
    }
    // http://blog.csdn.net/garfy_/article/details/46821223
    // http://blog.csdn.net/canglingye/article/details/44177479#reply
    
	//Time Limit Exceeded
    // you need to treat n as an unsigned value
    public int hammingWeight0(int n) {
        int sum = 0;
        while (n != 0) {
        	sum += n & 1;
        	n = n >> 1;
        }
        return sum;
    }
}
