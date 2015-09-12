package hard;

/**
 * 174	Dungeon Game
 * https://leetcode.com/problems/dungeon-game/
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * -2(K)	-3		3
 * -5		-10		1
 * 10		30		-5(P)
 * 
 * Notes:
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] ans = new int[m][n];
        ans[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 0 : -dungeon[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            ans[i][n - 1] = dungeon[i][n - 1] >= ans[i + 1][n - 1] ? 0 : ans[i + 1][n - 1] - dungeon[i][n - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            ans[m - 1][j] = dungeon[m - 1][j] >= ans[m - 1][j + 1] ? 0 : ans[m - 1][j + 1] - dungeon[m - 1][j];
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = dungeon[i][j] >= ans[i + 1][j] ? 0 : ans[i + 1][j] - dungeon[i][j];
                int right = dungeon[i][j] >= ans[i][j + 1] ? 0 : ans[i][j + 1] - dungeon[i][j];
                ans[i][j] = Math.min(down, right);
            }
        }
        
        return ans[0][0] + 1;
    }
}
// http://blog.csdn.net/ljiabin/article/details/42616291