package easy;

/**
 * 9. Palindrome Number 
 * https://leetcode.com/problems/palindrome-number/
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)  return false;
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int begin = x / div;
            int end = x % 10;
            if (begin != end)   return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}