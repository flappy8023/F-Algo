package poj.p1321;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月16日 09:26:00
 */
public class Main {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (-1 == n && -1 == k) return;
            char[][] chess = new char[n][n];
            boolean[][] visit = new boolean[n][n];
            count = 0;
            for (int i = 0; i < n; i++) {
                char[] letters = scanner.next().toCharArray();
                for (int j = 0; j < letters.length; j++) {
                    chess[i][j] = letters[j];
                }
            }
            dfs(0, chess, k, visit);
            System.out.println(count);
        }

    }

    private static boolean isOk(int r, int c, boolean[][] visit) {
        for (int i = 0; i < visit.length; i++) {
            if (visit[i][c]) return false;
        }
        return true;
    }

    private static void dfs(int i, char[][] chess, int k, boolean[][] visit) {
        if (k == 0) {
            count++;
            return;
        }
        if(i>=chess.length)return;
        //第i行放一个棋子
        for (int j = 0; j < chess[i].length; j++) {
            if ('#' == chess[i][j] && isOk(i, j, visit)) {
                visit[i][j] = true;
                dfs(i + 1, chess, k - 1, visit);
                visit[i][j] = false;
            }
        }
        //不放
        dfs(i + 1, chess, k, visit);

    }
}
