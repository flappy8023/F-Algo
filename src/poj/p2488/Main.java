package poj.p2488;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月15日 14:51:00
 */
public class Main {
    static String[] result;
    static boolean ok = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            System.out.println("Scenario #" + (i + 1) + ":");
            search(p, q, i);
            if (!ok) {
                System.out.println("impossible");
            }
            System.out.println();

        }
    }

    private static void search(int p, int q, int i) {
        boolean[][] visit;
        for (int j = 0; j < p; j++) {
            for (int k = 0; k < q; k++) {
                visit = new boolean[p][q];
                result = new String[p * q];
                ok = false;
                //遍历所有起点
                dfs(j, k, visit, 0);
                if (ok) {
                    return;
                }
            }
        }
    }

    private static void dfs(int p, int q, boolean[][] visit, int num) {
        if (ok) return;
        if (num == visit.length * visit[0].length) {
            ok = true;
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
        }
        if (!isOk(p, q, visit)) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            visit[p][q] = true;
            result[num++] = String.valueOf((char) ('A' + q)) + (p + 1);
            switch (i) {
                case 0:
                    dfs(p - 1, q - 2, visit, num);
                    break;
                case 1:
                    dfs(p + 1, q - 2, visit, num);
                    break;
                case 2:
                    dfs(p - 2, q - 1, visit, num);
                    break;
                case 3:
                    dfs(p + 2, q - 1, visit, num);
                    break;
                case 4:
                    dfs(p - 2, q + 1, visit, num);
                    break;
                case 5:
                    dfs(p + 2, q + 1, visit, num);
                    break;
                case 6:
                    dfs(p - 1, q + 2, visit, num);
                    break;
                case 7:
                    dfs(p + 1, q + 2, visit, num);
                    break;

            }
            result[--num] = "";
            visit[p][q] = false;

        }


    }


    private static boolean isOk(int p, int q, boolean[][] visit) {
        return p >= 0 && q >= 0 && p < visit.length && q < visit[0].length && !visit[p][q];
    }
}
