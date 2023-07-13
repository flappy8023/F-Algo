package leetcode._1049LastStoneWeightII;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 01背包
 * @createTime 2023年07月12日 17:03:00
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        //目标就是分成两组，要求两组和的差值尽可能小
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        //另一组最大重量：sum-dp[target],由于sum/2向下取整，sum-dp[target]>=dp[target]
        return sum - dp[target] - dp[target];
    }
}
