package leetcode._279PerfectSquares;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Auther: luweiming
 * @Date: 2023/7/24 22:34
 * @Description:
 */
public class Solution {
    public int numSquares(int n) {
        //dp[j]凑成j所需要的完全平方数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //dp[j] = min(dp[j],dp[j-nums[i]]+1)

        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                //完全平方数一定可以凑成
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
