package medium;

/**
 * 201	Bitwise AND of Numbers Range
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */
public class Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m << offset;
    }
}
//http://www.cnblogs.com/aboutblank/p/4442193.html
//http://www.cnblogs.com/gonuts/p/4436574.html