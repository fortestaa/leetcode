package easy;

/**
 * 36 Valid Sudoku 
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        
        for (int i = 0; i < 9; i++) {
            boolean[] map = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int curr = board[i][j] - '1';
                    if (map[curr])  return false;
                    map[curr] = true;
                }
            }
        }
        
        for (int j = 0; j < 9; j++) {
            boolean[] map = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int curr = board[i][j] - '1';
                    if (map[curr])  return false;
                    map[curr] = true;
                }
            }
        }
        
        for (int block = 0; block < 9; block++) {
            boolean[] map = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        int curr = board[i][j] - '1';
                        if (map[curr])  return false;
                        map[curr] = true;
                    }
                }
            }
        }
        
        return true;
    }
}
// http://blog.csdn.net/linhuanmars/article/details/20748171