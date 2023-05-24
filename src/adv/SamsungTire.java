package adv;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName SamsangTire.java
 * @Description 倒叙遍历 https://blog.csdn.net/qq_42837890/article/details/125279764?spm=1001.2014.3001.5502
 * @createTime 2023年05月24日 09:37:00
 */
public class SamsungTire {
    private static int min = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            min = K;
            int[][] ops = new int[N][2];
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < N; l++) {
                    ops[l][j] = scanner.nextInt();
                }
            }
            boolean[] visit = new boolean[N];
            for (int j = 0; j < K; j++) {
                //倒着遍历，当最后一次操作
                dfs(j, 0, N, K, ops, visit);
            }
            if (min == K) {
                System.out.println("#" + (i + 1) + " " + (-1));
            } else {
                System.out.println("#" + (i + 1) + " " + min);
            }
        }
    }

    /**
     * @param rest  进行操作前的剩余气压
     * @param count 当前操作次数
     * @param N     操作总次数
     * @param K     最大气压
     * @param ops
     * @param visit
     */
    private static void dfs(int rest, int count, int N, int K, int[][] ops, boolean[] visit) {
        if (count == N) {
            min = Math.min(rest, min);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            //放气前
            int r = rest + ops[i][1];
            //充气前
            int r1 = r - ops[i][0];
            if (r <= K && r1 >= 0) {
                dfs(r1, count + 1, N, K, ops, visit);
            }
            visit[i] = false;
        }

    }
}
