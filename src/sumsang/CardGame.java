package sumsang;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName CardGame.java
 * @Description TODO
 * @createTime 2023年06月05日 10:59:00
 */
public class CardGame {
    private static int maxScore = 0; // 用于记录最大得分

    public static int getMaxScore(int N, int K, int[] A, int[] T) {
        int[] count = new int[4]; // 记录每种花色的数量
        long s = System.currentTimeMillis();
        System.out.println("s="+s);
        dfs(N, K, A, T, count, 0, 0);
        long e = System.currentTimeMillis();
        System.out.println("e="+e);
        System.out.println(e - s);
        return maxScore;
    }

    private static void dfs(int N, int K, int[] A, int[] T, int[] count, int cardIndex, int currentScore) {
        if (cardIndex >= N) {

            return;
        }
        if(K==0){
            // 达到边界条件，更新最大得分
            maxScore = Math.max(maxScore, currentScore);
            return;
        }
        for (int i = cardIndex; i < N; i++) {
            // 选择第i张牌
            count[A[i]]++;
            int newScore = currentScore + T[i] + count[A[i]]*2 - 1;

            // 进行剪枝
            if (N - i < K) {
                // 剩余牌数不足以选满K张牌，剪枝
                count[A[i]]--;
                return;
            }

            dfs(N, K - 1, A, T, count, i + 1, newScore);

            // 撤销选择
            count[A[i]]--;
        }
    }

    public static void main(String[] args) {
        int N = 20;
        int K = 19;
        int[] A = {0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, };
        int[] T = {999,9999,20,1999,2999,2993,2871,2887,9999,2736,20,100,0,9,0,99,23,3,4,555};
//        int N = 80;
//        int K = 28;
//        int[] A = {0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, 0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, 0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, 0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2,};
//        int[] T = {999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555, 999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555, 999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555, 999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555};
        int maxScore = getMaxScore(N, K, A, T);
        System.out.println(maxScore);
    }
}
