package adv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName HumburgerMaster.java
 * @Description TODO
 * @createTime 2023年05月24日 15:14:00
 */
public class HamburgerMaster {
    private static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            //用二位矩阵记录两种材料的相克关系
            int[][] filters = new int[N + 1][N + 1];
            for (int j = 0; j < M; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                //a->b,b->a
                filters[a][b] = 1;
                filters[b][a] = 1;
            }
            result = 0;
            for (int j = 0; j <= N; j++) {
                boolean[] visit = new boolean[N + 1];
                dfs(filters, N, j, 0, visit, new ArrayList<>(), 1);
            }
            System.out.println("# " + (i + 1) + " " + result);
        }

    }

    private static void dfs(int[][] filters, int N, int num, int step, boolean[] visit, List<Integer> list, int addNum) {
        if (num == step) {
            result++;
            return;
        }
        for (int i = addNum; i <= N; i++) {
            if (visit[i]) continue;
            if (isOK(filters, i, list)) {
                visit[i] = true;
                list.add(i);
                dfs(filters, N, num, step + 1, visit, list, i);
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isOK(int[][] filters, int num, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (filters[num][list.get(i)] == 1) {
                return false;
            }
        }
        return true;
    }
}
