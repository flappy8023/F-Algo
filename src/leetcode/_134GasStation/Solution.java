package leetcode._134GasStation;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 暴力
 * @createTime 2023年07月05日 17:16:00
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //从某个可行位置出发后的总剩余油量
        int curSum = 0;
        //经过所有站点后的油量
        int totalSum = 0;
        //起始位置
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            //如果从某一位置出发到i位置总剩余油量为负数，说明从这一位置到i都无法走完，需要从i+1作为出发位置重新计算
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        //总剩余油量小于0，说明任何一个位置都跑不了一圈
        return totalSum < 0 ? -1 : start;
    }
}
