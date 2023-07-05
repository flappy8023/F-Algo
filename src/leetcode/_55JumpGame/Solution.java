package leetcode._55JumpGame;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月05日 10:35:00
 */
public class Solution {
    //
    public boolean canJump(int[] nums) {
        //当前位置跳跃能覆盖的最大下标
        int cover = 0;
        int index = 0;
        if (nums.length == 1) return true;
        //下标始终在最大覆盖范围之内
        while (index <= cover) {
            cover = Math.max(nums[index] + index, cover);
            index++;
            //覆盖范围达到了数组长度
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}
