package leetcode._174DungeonGame;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description dfs
 * @createTime 2023年05月11日 16:07:00
 */
public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int columns = dungeon[0].length;
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, rows, columns, dungeon, dp) + 1;
    }

    private int dfs(int rIndex, int cIndex, int rows, int columns, int[][] dungeon, int[][] dp) {

        if (rIndex >= rows || cIndex >= columns) return Integer.MAX_VALUE;
        if (rIndex == rows - 1 && cIndex == columns - 1) {
            if (dungeon[rIndex][cIndex] >= 0) {
                return 0;
            } else {
                return -dungeon[rIndex][cIndex];
            }
        }

        //右边格子需要的最少血量
        int right = (rIndex < rows - 1) && dp[rIndex + 1][cIndex] != -1 ? dp[rIndex + 1][cIndex] : dfs(rIndex + 1, cIndex, rows, columns, dungeon, dp);
        //下面格子需要的最少血量
        int down = (cIndex < columns - 1) && dp[rIndex][cIndex + 1] != -1 ? dp[rIndex][cIndex + 1] : dfs(rIndex, cIndex + 1, rows, columns, dungeon, dp);
        //推导公式
        int min = Math.min(right, down) - dungeon[rIndex][cIndex];
        if (min < 0) {
            min = 0;
        }
        dp[rIndex][cIndex] = min;
        return min;
    }


}
