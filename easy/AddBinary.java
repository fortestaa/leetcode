package easy;

/**
 * 67 Add Binary
 * https://leetcode.com/problems/add-binary/
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        String res = "";
        int m = a.length(), n = b.length();
        int i = 0, carry = 0;
        while (i < m || i < n) {
            int p = i < m ? a.charAt(m - 1 - i) - '0' : 0;
            int q = i < n ? b.charAt(n - 1 - i) - '0' : 0;
            int temp = p + q + carry;
            res = temp % 2 + res;
            carry = temp / 2;
            i++;
        }
        return carry == 0 ? res : "1" + res;
    }
}