package leetcode._494TargetSum;

import java.util.Arrays;

/**
 * @Auther: luweiming
 * @Date: 2023/7/17 14:22
 * @Description:
 */
public class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        //所有带加号的数字和为p,带减号的数字和为q，所有数字和为sum,那么p-q = target,又有q = sum-q,可以推到p-(sum-p) = target，即p=(target+sum)/2;
        //那么题目可以看作从数组中选出若干个数字，组成的和为(target+sum)/2,要求出总共有多少种组合;
        //dp[j]代表数组中可以组成和为j的组合数量
        int sum = Arrays.stream(nums).sum();
        //p不可能是负数
        if ((sum + target) < 0) return 0;
        //p需要是整数，整除2得到
        if ((sum + target) % 2 == 1) return 0;
        int bagSize = (sum + target) / 2;
        int[] dp = new int[bagSize + 1];
        //why？
        dp[0] = 1;
        //只要有了nums[i],那么就有dp[j-nums[i]]种方法凑出j，那么dp[j]+=dp[j-nums[i]]
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
