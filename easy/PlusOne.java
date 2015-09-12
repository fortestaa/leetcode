package easy;

/**
 * 66 Plus One
 * https://leetcode.com/problems/plus-one/
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit < 9) {
                digits[i] += 1;
                return digits;
            } else {
                if (i != 0) {
                    digits[i] = 0;
                } else {	// 这种情况下，由于加1之后会加上一位，这意味着在此之后都会为0 —— 99 ＋ 1 ＝ 100
                    int[] res = new int[len + 1];
                    res[0] = 1;
                    return res;
                }
            }
        }
        return digits;
    }
}
