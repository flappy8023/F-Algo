package leetcode._509斐波那契数;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 动态规划
 * @createTime 2023年07月08日 15:49:00
 */
public class Solution {
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int[] dp = new int[2];
        //dp[i] = dp[i-1]+dp[i-2]
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
