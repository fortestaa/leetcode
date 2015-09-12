package medium;

/**
 * 69	Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
public class Sqrtx {
    public int mySqrt(int x) {
        long i = 0;
        long j = x / 2 + 1;
        while (i <= j) {
        	long mid = (i + j) / 2;
        	if (mid * mid == x)	return (int)mid;
        	else if (mid * mid < x)	i = mid + 1;
        	else	j = mid - 1;
        }
        return (int)j;
    }
    
    public static void main(String[] args) {
    	Sqrtx s = new Sqrtx();
    	System.out.println(s.mySqrt(9));
    	System.out.println(s.mySqrt(2));
    }
}
// The complexity is O(log x).
//http://www.lifeincode.net/programming/leetcode-sqrtx-java/