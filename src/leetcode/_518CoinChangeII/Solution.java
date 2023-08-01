package leetcode._518CoinChangeII;

/**
 * @Auther: luweiming
 * @Date: 2023/7/18 14:55
 * @Description:
 */
public class Solution {
    public int change(int amount, int[] coins) {
        //dp[j]:可以组成价值j的组合方法
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        //先遍历物品，再遍历背包，得到的是组合数；先遍历背包，再遍历物品得到的是排列数
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
