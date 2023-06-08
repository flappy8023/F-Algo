package leetcode._209MinimumSizeSubarraySum;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月08日 15:00:00
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        //滑动窗口起始位置
        int j = 0;
        int sum = 0;
        //i 滑动窗口结束位置
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //当窗口数字的和超出target时，窗口起始位置左移缩小窗口
            while (sum >= target) {
                result = Math.min(result, i - j + 1);
                sum -= nums[j++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
