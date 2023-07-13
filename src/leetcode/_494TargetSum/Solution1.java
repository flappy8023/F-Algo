package leetcode._494TargetSum;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description 记忆化搜索
 * @createTime 2023年07月13日 14:52:00
 */
public class Solution1 {
    int[][] cache;

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        //设想所有带加好的加起来的元素和为p，带负号的元素和为q，有q = sum-p,要求p-q = target，即p-(sum-p) = target
        //可以得出p = (target+sum)/2，问题转化为从nums数组中选择元素和为（target+sum）/2的情况数量
        int total = sum + target;
        //总和为负数的话，p也是负数，不合法
        if(total<0)return 0;
        //如果target+sum为奇数则不存在
        if (total % 2 == 1) return 0;
        cache = new int[nums.length][total / 2 + 1];
        for (int i = 0; i < cache.length; i++) {

            Arrays.fill(cache[i], -1);
        }
        return dfs(nums, nums.length - 1, total/2);
    }

    /**
     * 从下标0-c中选择元素凑出和为target的情况数量
     *
     * @param nums
     * @param c      下标 0-c中选择元素
     * @param target 目标和
     * @return
     */
    private int dfs(int[] nums, int c, int target) {
        if (c < 0) return target == 0 ? 1 : 0;
        if (-1 != cache[c][target]) return cache[c][target];
        //最后一个元素比目标和还要大，那么肯定不选最后一个元素下标c,取c-1
        if (target < nums[c]) {
            return cache[c][target] = dfs(nums, c - 1, target);
        }
        //两种情况：1.取下标为c的元素，dfs(nums,c-1,target-nums[c]);2.不取下标为c的元素，dfs(nums,c-1,target)
        return dfs(nums, c - 1, target - nums[c]) + dfs(nums, c - 1, target);

    }
    
}
