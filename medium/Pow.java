package medium;

/**
 * 50 Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 * 
 * Implement pow(x, n).
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double res = 1.0;
        if (n < 0) {
            if (x >= 1.0 / Double.MAX_VALUE || x <= 1.0 / -Double.MAX_VALUE) {
                x = 1.0 / x;
            } else {
                return Double.MAX_VALUE;
            }
            if (n == Integer.MIN_VALUE) {
                res *= x;
                n++;
            }
        }
        n = Math.abs(n);
        boolean isNeg = false;
        if (x < 0 && n % 2 == 1)    isNeg = true;
        x = Math.abs(x);
        while (n > 0) {
            if ((n & 1) == 1) {
                if (res > Double.MAX_VALUE / x) return Double.MAX_VALUE;
                res *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return isNeg ? -res : res;
    }

    public double myPow1(double x, int n) {
        if (n < 0) {
            return 1.0 / power(x, -n);
        } else {
            return power(x, n);
        }
    }
    private double power(double x, int n) {
        if (n == 0) return 1.0;
        double v = power(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    // http://fisherlei.blogspot.com/2012/12/leetcode-powx-n.html
}
// http://blog.csdn.net/linhuanmars/article/details/20092829