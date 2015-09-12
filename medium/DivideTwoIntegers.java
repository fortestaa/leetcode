package medium;

/**
 * 29 Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)   return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
        
        int rst = 0;
        while (pDividend >= pDivisor) {
            int numShift = 0;
            while (pDividend >= (pDivisor << numShift)) {
                numShift++;
            }
            rst += 1 << (numShift - 1);
            pDividend -= (pDivisor << (numShift - 1));
        }
        
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return rst;
        } else {
            return -rst;
        }
    }
}
/*
 * This problem can be solved based on the fact that any number can be converted to the format of the following:
 * num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
 * The time complexity is O(logn).
 */
// http://www.programcreek.com/2014/05/leetcode-divide-two-integers-java/