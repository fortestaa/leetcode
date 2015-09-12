package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 50 Pow(x, n)
 * https://leetcode.com/problems/n-queens/
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle: 
 * [ 
 * 	[".Q..", // Solution 1 
 * 	 "...Q",
 * 	 "Q...",
 * 	 "..Q."],
 * 
 * 	["..Q.", // Solution 2
 * 	 "Q...",
 * 	 "...Q",
 * 	 ".Q.."] 
 * ]
 */
public class NQueens {
    List<List<String>> res;
    int[] A;	// 第i行的queen应该放在第几列——n行应每行一个queen
    
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        A = new int[n];
        nqueens(0, n);
        return res;
    }
    
    public void nqueens(int cur, int n) {
        if (cur == n) {
            printres(n);
        } else {
            for (int i = 0; i < n; i++) {
                A[cur] = i;
                if (valid(cur)) {
                    nqueens(cur + 1, n);
                }
            }
        }
    }
    
    public void printres(int n) {
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (j == A[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            temp.add(sb.toString());
        }
        res.add(temp);
    }
    
    public boolean valid(int cur) {
        for (int i = 0; i < cur; i++) {
            if (A[cur] == A[i] || Math.abs(A[cur] - A[i]) == cur - i) {
                return false;
            }
        }
        return true;
    }

    // http://blog.csdn.net/sbitswc/article/details/32033655
}
// http://haolloyin.blog.51cto.com/1177454/353105/