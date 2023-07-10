package leetcode._070爬楼梯;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description 动态规划
 * @createTime 2023年07月08日 16:03:00
 */
public class Solution1 {
    public int climbStairs(int n){
        if(n<=2){
            return n;
        }
        //dp[i] = dp[i-1]+dp[i-2]
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i <=n ; i++) {
            int sum = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.climbStairs(4);
    }
}
