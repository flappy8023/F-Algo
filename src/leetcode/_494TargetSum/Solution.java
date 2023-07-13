package leetcode._494TargetSum;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 回溯
 * @createTime 2023年07月13日 09:31:00
 */
public class Solution {
    private int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backTracking(nums, target, 0, 0);
        return result;
    }

    private void backTracking(int[] nums, int target, int index, int sum) {
        if (nums.length == index) {
            if (sum == target) {
                result++;
            }
            return;
        }

        backTracking(nums, target, index + 1, sum + nums[index]);

        backTracking(nums, target, index + 1, sum - nums[index]);
    }
}
