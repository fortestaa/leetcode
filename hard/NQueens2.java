package hard;

/**
 * 52	N-Queens II
 * https://leetcode.com/problems/n-queens-ii/
 * 
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueens2 {
    int[] A;
    int res;
    
    public int totalNQueens(int n) {
        A = new int[n];
        res = 0;
        nqueens(0, n);
        return res;
    }
    
    public void nqueens(int cur, int n) {
        if (cur == n) {
            res++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                A[cur] = i;
                if (valid(cur)) {
                    nqueens(cur + 1, n);
                }
            }
        }
    }
    
    public boolean valid(int cur) {
        for (int i = 0; i < cur; i++) {
            if (A[cur] == A[i] || Math.abs(A[cur] - A[i]) == cur - i) {
                return false;
            }
        }
        return true;
    }
}
// http://blog.csdn.net/sbitswc/article/details/32034873