package leetcode._376WiggleSubsequence;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月04日 16:39:00
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        //当前元素与前一个元素的差值
        int preDiff = 0;
        //下一个元素与当前元素的差值
        int curDiff = 0;
        //最后一个元素固定认为是一个峰值
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            //三种情况：
            /**
             * 1.上下坡带平坡
             *    _____
             *   /     \
             *
             * 2.只有两个元素
             * 3. 单调上坡或者下坡带平坡(只有当遇到峰值时才更新preDiff)
             *
             *  _____/
             * /
             *
             */
            curDiff = nums[i + 1] - nums[i];
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
