package leetcode._474OnesAndZeroes;

/**
 * @Auther: luweiming
 * @Date: 2023/7/17 16:02
 * @Description: 01背包
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]代表包含最大i个0，j个1的最大子数组长度
        //上个字符串包含num0个0，num1个1，那么dp[i][j]可以是dp[i-num0][j-num1]+1，遍历过程中取最大值
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int num0 = 0, num1 =0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0')
                    num0++;
                else
                    num1++;
            }
          for (int p = m;p>=num0;p--){
              for (int q= n;q>=num1;q--){
                  dp[p][q] = Math.max(dp[p-num0][q-num1]+1,dp[p][q]);
              }
          }
        }
        return dp[m][n];
    }
}
