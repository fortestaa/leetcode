package easy;

/**
 * 258 Add Digits
 * https://leetcode.com/problems/add-digits/
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example: 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 * Hint:
 * A naive implementation of the above process is trivial. 
 * Could you come up with other methods? What are all the possible results? 
 * How do they occur, periodically or randomly? You may find this Wikipedia article useful.
 */
public class AddDigits {
    public int addDigits(int num) {
    	int res = 0;
    	if (num < 10)	return num;
        while (num != 0) {
        	int digit = num % 10;
        	res += digit;
        	num = num / 10;
        }
        return addDigits(res);
    }
    
    public static void main(String[] args) {
    	AddDigits s = new AddDigits();
    	System.out.println(s.addDigits(38));
    }
}
