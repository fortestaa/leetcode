package medium;

/**
 * 79 Word Search
 * https://leetcode.com/problems/word-search/
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example, Given board =
 * [
 *  ["ABCE"], 
 *  ["SFCS"], 
 *  ["ADEE"] 
 * ] 
 * word = "ABCCED", -> returns true, 
 * word = "SEE", -> returns true, 
 * word = "ABCB", -> returns false.
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length())
            return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return false;
        if (visited[row][col])
            return false;
        if (board[row][col] != word.charAt(index))
            return false;
        visited[row][col] = true;
        boolean res = dfs(board, word, index + 1, row - 1, col, visited)
            || dfs(board, word, index + 1, row + 1, col, visited)
            || dfs(board, word, index + 1, row, col - 1, visited)
            || dfs(board, word, index + 1, row, col + 1, visited);
        visited[row][col] = false;
        return res;
    }
}
// http://www.cnblogs.com/springfor/p/3883942.html