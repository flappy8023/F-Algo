package adv;

import java.util.*;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Plumber.java
 * @Description TODO
 * @createTime 2023年05月25日 15:10:00
 */
public class Plumber {
    static int LEFT = 1;
    static int RIGHT = 2;
    static int TOP = 3;
    static int BOTTOM = 4;

    private static List<String> result = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] farm = new int[N + 1][M + 1];
        boolean[][] visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                farm[i][j] = scanner.nextInt();
            }
        }
        dfs(1, 1, LEFT, visit, N, M, new ArrayList<String>(), farm);
        if (result.isEmpty()) {
            System.out.print("impossible");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.printf(result.get(i));
            }
        }
        System.out.println();

    }

    private static void dfs(int r, int c, int front, boolean[][] visit, int N, int M, List<String> list, int[][] farm) {
        if (r == N && c == M + 1 && front == LEFT) {
            result = new ArrayList<>(list);
            return;
        }
        if (r < 1 || c < 1 || r > N || c > M || visit[r][c]) return;

        int type = farm[r][c];
        visit[r][c] = true;
        list.add("(" + r + "," + c + ")");
        //直的
        if (type == 5 || type == 6) {
            if (front == 1) {
                dfs(r, c + 1, LEFT, visit, N, M, list, farm);
            } else if (front == 2) {
                dfs(r, c - 1, RIGHT, visit, N, M, list, farm);
            } else if (front == 3) {
                dfs(r + 1, c, TOP, visit, N, M, list, farm);
            } else {
                dfs(r - 1, c, BOTTOM, visit, N, M, list, farm);
            }
        }
        if (type >= 1 && type <= 4) {
            if (front == LEFT) {
                dfs(r + 1, c, TOP, visit, N, M, list, farm);
                dfs(r - 1, c, BOTTOM, visit, N, M, list, farm);
            } else if (front == RIGHT) {
                dfs(r + 1, c, TOP, visit, N, M, list, farm);
                dfs(r - 1, c, BOTTOM, visit, N, M, list, farm);
            } else if (front == TOP) {
                dfs(r, c + 1, LEFT, visit, N, M, list, farm);
                dfs(r, c - 1, RIGHT, visit, N, M, list, farm);
            } else {
                dfs(r, c + 1, LEFT, visit, N, M, list, farm);
                dfs(r, c - 1, RIGHT, visit, N, M, list, farm);
            }
        }
        visit[r][c] = false;
        list.remove(list.size() - 1);


    }
}
