package leetcode._416PartitionEqualSubsetSum;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 01背包
 * @createTime 2023年07月11日 10:15:00
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        //转化为01背包，背包容量sum/2，
        int[] dp = new int[sum / 2 + 1];
        //dp[j] = max(dp[j],dp[j-nums[i]]+nums[i]]
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum / 2] == sum / 2;
    }
}
