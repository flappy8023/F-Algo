package sumsang;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName CardGame.java
 * @Description FIXME maybe wrong
 * @createTime 2023年06月05日 10:59:00
 */
public class CardGame2 {
    private static int maxScore = 0; // 用于记录最大得分

    public static int getMaxScore(int N, int K, int[] A, int[] T) {
        int[] count = new int[4]; // 记录每种花色的数量
        int[][] dp = new int[2][K + 1];
        long s = System.currentTimeMillis();
        System.out.println("s=" + s);
        //1.dp[i][j]含义从i张卡牌中选出j张卡牌最大的得分
        //2.动态转移方程 dp[i][j] = Max(dp[i-1][j],dp[i-1][j-1]+T[i]+count[A[i]]*2-1)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if(j>i){
                    dp[i%2][j] = 0;
                }
                dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - 1] + T[i - 1] + 2 * count[A[i - 1]] + 1);

            }
            count[A[i-1]]++;
        }
        long e = System.currentTimeMillis();
        System.out.println("e=" + e);
        System.out.println(e - s);
        return dp[N % 2][K];
    }


    public static void main(String[] args) {
        int N = 20;
        int K = 19;
        int[] A = {0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2,};
        int[] T = {999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555};
//        int N = 80;
//        int K = 28;
//        int[] A = {0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, 0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, 0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, 0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2,};
//        int[] T = {999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555, 999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555, 999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555, 999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555};
        int maxScore = getMaxScore(N, K, A, T);
        System.out.println(maxScore);
    }
}
