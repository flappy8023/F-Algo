package leetcode._343IntegerBreak;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月10日 15:16:00
 */
public class Solution {
    public int integerBreak(int n) {

        //n=2,max = 1*1=1;
        //n=3,max = 1*2 = 2;
        //n=4,max = 2*2 = 4;
        //n=5,max = 2*3 = 6
        //n=6,max = 3*3 = 9
        //n=7,max = 2*2*3 = 12,
        //n=8,max = 2*3*3 = 18
        //n=9,max = 3*3*3 =27,
        //n=10,max = 3*3*4 = 36
        //dp[i]数字i拆分以后的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        //最大乘积：拆分成两个、拆分成两个以上的数字乘积较大值
        //dp[i]=max(dp[i],max(j*(i-j),(i-j)*dp[j]))
        for (int i = 3; i <= n; i++) {
            //只需要到i/2，会有重复
            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
