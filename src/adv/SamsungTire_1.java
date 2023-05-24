package adv;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName SamsangTire.java
 * @Description 正序遍历 https://blog.csdn.net/qq_42837890/article/details/125279764?spm=1001.2014.3001.5502
 * @createTime 2023年05月24日 09:37:00
 */
public class SamsungTire_1 {
    private static int min = -1;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            min = -1;
            int[][] ops = new int[N][2];
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < N; l++) {
                    ops[l][j] = scanner.nextInt();
                }
            }
            boolean[] visit = new boolean[N];
            flag = false;
            for (int j = 0; j < K; j++) {

                dfs(j, 0, N, K, ops, visit);
                //找到第一个就是最小的不需要继续
                if (flag) {
                    min = j;
                    break;
                }
            }
            System.out.println("#" + (i + 1) + " " + min);
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
            flag = true;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            if (rest + ops[i][0] <= K && rest + ops[i][0] - ops[i][1] >= 0) {
                dfs(rest + ops[i][0] - ops[i][1], count + 1, N, K, ops, visit);
            }
            visit[i] = false;
        }
    }
}
