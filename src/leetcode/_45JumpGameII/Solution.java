package leetcode._45JumpGameII;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月05日 14:13:00
 */
public class Solution {
    public int jump(int[] nums) {
        //当前可以达到的最远下标
        int end = 0;
        //下一跳可以到达的最远下标
        int maxPos = 0;
        int result = 0;
        //如果达到了集合末端，末端正好为最后一个位置的情况下，会增加一次不必要的跳跃次数
        for (int i = 0; i < nums.length - 1; i++) {
            //i遍历过程中，不断更新下一跳的最远位置
            maxPos = Math.max(nums[i] + i, maxPos);
            //到达当前的最远点，更新为下一跳的最远点,增加一次跳跃次数
            if(i==end){
                end = maxPos;
                result++;
            }
        }
        return result;
    }
}
