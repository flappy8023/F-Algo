package leetcode._122买卖股票的最佳时机II;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description 贪心
 * @createTime 2023年07月05日 10:09:00
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        //计算每一天的收益，只收集正收益,相加就是最大收益
        int sum = 0;
        for (int i = 1; i <prices.length ; i++) {
            int profit = prices[i]-prices[i-1];
            if(profit>0){
                sum+=profit;
            }
        }
        return sum;
    }
}
