package leetcode._62UniquePaths;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 动态规划
 * @createTime 2023年07月10日 10:33:00
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        //1.dp[i][j]代表从起点到达[i,j]的路径数
        int[][] dp = new int[m][n];
        //2.dp[i][j] = dp[i-1][j]+dp[i][j-1]
        //3.初始化上边一行和左边一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //4.遍历顺序肯定是从上往下 从左往右
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
