package adv;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName ThreeKingdoms_Chapter1.java
 * @Description https://blog.csdn.net/qq_42837890/article/details/125210265?spm=1001.2014.3001.5502
 * @createTime 2023年05月25日 17:28:00
 */
public class ThreeKingdoms_Chapter1 {
    private static int M;
    private static int N;
    private static int K;
    private static int[][] arms;
    private static boolean[] trains;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            M = scanner.nextInt();
            N = scanner.nextInt();
            K = scanner.nextInt();
            arms = new int[K][3];
            trains = new boolean[K];
            for (int j = 0; j < K; j++) {
                arms[j][0] = scanner.nextInt();
                arms[j][1] = scanner.nextInt();
                arms[j][2] = scanner.nextInt();
            }
            dfs(M, 0, 0);
            System.out.println("#"+(i+1)+" "+max);
        }
    }

    private static void dfs(int rest, int month, int power) {
        if (rest < 0) return;
        if (month == N) {
            max = Math.max(max, power);
            return;
        }
        for (int i = 0; i < K; i++) {
            //训练这支新部队
            if (!trains[i]) {
                trains[i] = true;
                dfs(rest - arms[i][0], month + 1, power + arms[i][1] + getIncrement(i));
                trains[i] = false;
            }
            //不招募新部队
            dfs(rest, month + 1, power + getIncrement(-1));
        }
    }

    private static int getIncrement(int index) {
        int increment = 0;
        for (int i = 0; i < trains.length; i++) {
            if (trains[i] && i != index) {
                increment += arms[i][2];
            }
        }
        return increment;
    }
}
