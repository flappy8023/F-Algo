package leetcode._053最大子序和;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution2.java
 * @Description 动态规划
 * @createTime 2023年07月05日 09:34:00
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        //1.dp数组含义：dp[i]表示以nums[i]结尾的前i个元素的最大子序和
        //2.确定递推关系:dp[i] = max(dp[i-1]+nums[i],nums[i])
        //3.初始化dp数组：dp[0]= nums[0]
        //4.确定遍历顺序：正序
        //5.举例推导dp数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            //更新最大子序和
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
