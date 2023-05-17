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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (-1 == n && -1 == k) return;
            String[][] chess = new String[n][n];

            int index = 0;
            for (int i = 0; i < n; i++) {
                String line = scanner.next();
                String[] letters = line.split(" ");
                for (int j = 0; j < letters.length; j++) {
                    chess[i][j] = letters[j];
                    if ("#".equals(chess[i][j])) {
                        index++;
                    }
                }
            }
            Point[] points = new Point[index];
            int in = 0;
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if ("#".equals(chess[i][j])) {
                        points[in++] = new Point(i, j);
                    }
                }
            }
            int count = 0;
            Point[] result = new Point[k];
            dfs(chess, points, count, 0, k, 0, result);

        }
    }

    private static void dfs(String[][] chess, Point[] points, int count, int index/*这步下第index个格子*/, int k, int step/*下了step个棋子*/, Point[] result) {
        if (step == k) {
            //排列中没有相同横纵坐标才记录
            if (check(result, 0)) {
                count++;
            }
            return;
        }
        if (points.length == index) {
            System.out.println(count);
            return;
        }

        for (int i = index; i < points.length; i++) {
            result[step] = points[index];
            dfs(chess, points, count, i + 1, k, step + 1, result);
            result[step] = null;
        }
    }

    private static boolean check(Point[] res, int start) {
        if (start == res.length) {
            return true;
        }
        for (int i = start; i < res.length - 1; i++) {
            Point p = res[start];
            if (res[i + 1] == null) return true;
            if (p.x == res[i + 1].x || p.y == res[i + 1].y) return false;
            return check(res, i);

        }
        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
