package medium;

/**
 * 264	Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/
 * 
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 * 
 * Hint:
 * The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 * The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 */
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        
        int[] uglynum = new int[n];
        uglynum[0] = 1;
        int next = 1;
        int i = 0, j = 0, k = 0;
        while (next < n) {
            int min = minT(uglynum[i] * 2, uglynum[j] * 3, uglynum[k] * 5);
            uglynum[next] = min;
            
            if (uglynum[i] * 2 == min)  i++;
            if (uglynum[j] * 3 == min)  j++;
            if (uglynum[k] * 5 == min)  k++;
            next++;
        }
        return uglynum[n - 1];
    }
    
    private int minT(int t1, int t2, int t3) {
        int min = t1 < t2 ? t1 : t2;
        return min < t3 ? min : t3;
    }
}
// http://blog.csdn.net/yangyao_iphone/article/details/47781757