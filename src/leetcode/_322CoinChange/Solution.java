package leetcode._322CoinChange;

import java.util.Arrays;

/**
 * @Auther: luweiming
 * @Date: 2023/7/24 22:15
 * @Description:
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[j]组成j所需要的最少元素数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //dp[j] = min(dp[j-coins[i]]+1,dp[j])
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
