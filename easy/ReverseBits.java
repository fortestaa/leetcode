package easy;

/**
 * 190	Reverse Bits
 * https://leetcode.com/problems/reverse-bits/
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 1; i != 0; i <<= 1) {
            ans <<= 1;
            if ((n & 1) == 1) {
                ans |= 1;
            }
            n >>= 1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
    	ReverseBits s = new ReverseBits();
    	int y = 0x01010101;
    	int z = s.reverseBits(y);
    	System.out.println(y);
    	System.out.println(z);
    }
}
// http://www.cnblogs.com/ziyoudefeng/archive/2012/09/14/2685112.html