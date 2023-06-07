package sumsang;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName CardGame.java
 * @Description TODO
 * @createTime 2023年06月05日 10:59:00
 */
public class CardGame1 {
    private static int maxScore = 0; // 用于记录最大得分

    public static int getMaxScore(int N, int K, int[] A, int[] T) {
        int[] count = new int[4]; // 记录每种花色的数量
        long s = System.currentTimeMillis();
        System.out.println("s=" + s);
        dfs(N, K, A, T, count, 0, 0, 0);
        long e = System.currentTimeMillis();
        System.out.println("e=" + e);
        System.out.println(e - s);
        return maxScore;
    }

    private static void dfs(int N, int K, int[] A, int[] T, int[] count, int cardIndex, int currentScore, int num) {
        if (N - cardIndex < K - num) {
            return;
        }
        if (cardIndex >= N) {
            return;
        }
        if (num == K) {
            maxScore = Math.max(currentScore, maxScore);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                dfs(N, K, A, T, count, cardIndex + 1, currentScore, num);
            } else {
                count[A[cardIndex]]++;
                int score = currentScore + T[cardIndex] + count[A[cardIndex]] * 2 - 1;
                dfs(N, K, A, T, count, cardIndex + 1, score, num + 1);
                count[A[cardIndex]]--;
            }
        }
    }

    public static void main(String[] args) {
//        int N = 80;
//        int K = 28;
//        int[] A = {0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, 0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, 0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2, 0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2,};
//        int[] T = {999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555, 999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555, 999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555, 999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555};
        int N = 20;
        int K = 19;
        int[] A = {0, 1, 2, 3, 0, 0, 1, 2, 3, 3, 2, 1, 2, 1, 3, 0, 1, 2, 3, 2,};
        int[] T = {999, 9999, 20, 1999, 2999, 2993, 2871, 2887, 9999, 2736, 20, 100, 0, 9, 0, 99, 23, 3, 4, 555};
        int maxScore = getMaxScore(N, K, A, T);
        System.out.println(maxScore);
    }
}
