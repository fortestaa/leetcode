package easy;

/**
 * 263	Ugly Number
 * https://leetcode.com/problems/ugly-number/
 * 
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num < 0)    return false;
        if (num == 1)   return true;
        
        while (num >= 2 && num % 2 == 0)    num /= 2;
        while (num >= 3 && num % 3 == 0)    num /= 3;
        while (num >= 5 && num % 5 == 0)    num /= 5;
        return num == 1;
    }

	// Time Limit Exceeded
    public boolean isUgly1(int num) {
        if (num == 1)	return true;
        
        for (int i = 2; i < num / 2; i++) {
        	if (num % i == 0 && (i != 2 || i != 3 || i != 5))	return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	UglyNumber u = new UglyNumber();
    	System.out.println(u.isUgly(14));
    }
}
// http://blog.sina.com.cn/s/blog_b4bfd3050101bxdt.html  google面试－变形