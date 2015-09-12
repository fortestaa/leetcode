package easy;

import java.util.HashMap;

/**
 * 202	Happy Number
 * https://leetcode.com/problems/happy-number/
 * 
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), 
 * or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(n, n);
        while (n != 1) {
        	n = getSquareSum(n);
        	if (map.containsKey(n))	return false;
        	map.put(n, n);
        }
        return true;
    }
    
    private int getSquareSum(int n) {
    	int res = 0;
    	while (n != 0) {
    		int digit = n % 10;
    		res += digit * digit;
    		n /= 10;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	HappyNumber s = new HappyNumber();
    	System.out.println(s.isHappy(19));
    }
}
