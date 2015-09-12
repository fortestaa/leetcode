package easy;

/**
 * 8. String to Integer (atoi)
 * (https://leetcode.com/problems/string-to-integer-atoi/)
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 */
public class String_to_Integer {
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    
    public int myAtoi(String str) {
        int i = 0, n = str.length();
        while (i < n && Character.isWhitespace(str.charAt(i)))  i++;
        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return num * sign;
    }
}