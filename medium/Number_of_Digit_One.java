package medium;

/**
 * 233	Number of Digit One
 * https://leetcode.com/problems/number-of-digit-one/
 * 
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * For example: Given n = 13, Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * Hint: Beware of overflow.
 */
public class Number_of_Digit_One {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            ones += (a + 8) / 10 * m;
            if (a % 10 == 1)    ones += b + 1;
        }
        return ones;
    }

    
    public static void main(String[] args) {
    	Number_of_Digit_One s = new Number_of_Digit_One();
    	System.out.println(s.countDigitOne(13));
    	System.out.println(s.countDigitOne(1));
    	System.out.println(s.countDigitOne(9));
    }
}
// http://blog.csdn.net/xudli/article/details/46798619