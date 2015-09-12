package medium;

import java.util.LinkedList;

/**
 * 130	Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) return;
        
        for (int i = 0; i < board[0].length; i++) {
            fill(board, 0, i);
            fill(board, board.length - 1, i);
        }
        
        for (int i = 0; i < board.length; i++) {
            fill(board, i, 0);
            fill(board, i, board[0].length - 1);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void fill(char[][] board, int i, int j) {
        if (board[i][j] != 'O') return;
        board[i][j] = '#';
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int code = i * board[0].length + j;
        queue.add(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int row = code / board[0].length;
            int col = code % board[0].length;
            
            if (row >= 1 && board[row - 1][col] == 'O') {
                queue.add((row - 1) * board[0].length + col);
                board[row - 1][col] = '#';
            }
            
            if (row <= board.length - 2 && board[row + 1][col] == 'O') {
                queue.add((row + 1) * board[0].length + col);
                board[row + 1][col] = '#';
            }
            
            if (col >= 1 && board[row][col - 1] == 'O') {
                queue.add(row * board[0].length + col - 1);
                board[row][col - 1] = '#';
            }
            
            if (col <= board[0].length - 2 && board[row][col + 1] == 'O') {
                queue.add(row * board[0].length + col + 1);
                board[row][col + 1] = '#';
            }
        }
    }
}
//http://www.cnblogs.com/springfor/p/3869853.html
//http://blog.csdn.net/a83610312/article/details/8959099