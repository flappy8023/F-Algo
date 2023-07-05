package leetcode._053最大子序和;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description 贪心算法
 * @createTime 2023年07月05日 09:27:00
 */
public class Solution1 {

    public int maxSubArray(int[] nums) {
        //最大子序和初始化为最小负数，当中间连续和大于已经记录的最大和时进行更新
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            //更新
            result = Math.max(sum,result);
            //当连续和小于0，说明新加入的元素使整体连续和见笑了，需要重新从下一个元素进行计算连续和
            if(sum<=0){
                sum = 0;
            }
        }
        return result;
    }
}
