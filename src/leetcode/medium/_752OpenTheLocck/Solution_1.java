package leetcode.medium._752OpenTheLocck;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution_1.java
 * @Description TODO
 * @createTime 2023年05月11日 21:17:00
 */
public class Solution_1 {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int columns = dungeon[0].length;
        //1.dp数组的定义 dp[i][j] 代表到终点的最小血量
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        //2.递推关系,dp[i][j] = max(0,min(dp[i+1][j],dp[i][j+1])-dungeon[i][j])

        //3.dp数组初始化
        //初始化最后一个
        dp[rows - 1][columns - 1] = Math.max(0, -dungeon[rows - 1][columns - 1]);
        //初始化最后一列
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][columns - 1] = Math.max(0, dp[i + 1][columns - 1] - dungeon[i][columns - 1]);
        }
        //初始化最后一行
        for (int i = columns - 2; i >= 0; i--) {
            dp[rows - 1][i] = Math.max(0, dp[rows - 1][i + 1] - dungeon[rows - 1][i]);
        }
        //4.确定遍历顺序,从右下角遍历
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--) {
                dp[i][j] = Math.max(0, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }

        //5.举例推导dp数组
        return dp[0][0] + 1;
    }
}
