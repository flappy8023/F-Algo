package leetcode._96UniqueBinarySearchTrees;

public class Solution {
    /**
     * @param n
     * @return
     */
    public int numTrees(int n) {
        //n=1      1
        //
        //n=2    2   1
        //      /     \
        //     1        2
        //n=3,能组成的二叉搜索树数量为：以1为头节点的二叉搜索树数量+以2为头节点的二叉搜索树数量+以3为头结点的二叉搜索树数量
        //以1为头节点：没有左子树，右子树的情况与n=2的情况一致
        //以2为头节点，左子树与n=1情况一致，右子树也与n=1情况一致
        //以3为头节点，左子树与n=2情况一致，没有右子树
        //dp[3] = dp[0]*dp[2]+dp[1]*dp[1]+dp[2]*dp[0]
        //dp[i]代表n=i时能组成的二叉搜索树数量
        int[] dp = new int[n + 1];
        //dp[i] = dp[i]+dp[j-1]*dp[i-j];  1<=j<i,不断累加
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
