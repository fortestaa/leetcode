package easy;

/**
 *7. Reverse Integer (https://leetcode.com/problems/reverse-integer/)
 * 
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class No7_ReverseInteger {
    private final static int MAXDIV10 = Integer.MAX_VALUE / 10;
    
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            if (Math.abs(ret) > MAXDIV10 || Math.abs(ret) == MAXDIV10 && x % 10 >= 8)   return 0;
            ret = ret * 10 + x % 10;
            x = x / 10;
        }
        return ret;
    }
    
    public static void main(String[] args) {
    	System.out.println(Integer.MAX_VALUE);
    }
}
