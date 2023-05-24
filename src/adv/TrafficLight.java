package adv;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName TrafficLight.java
 * @Description TODO
 * @createTime 2023年05月23日 22:48:00
 */
public class TrafficLight {
    static int red, yellow, blue;
    private static int max = 0;
    private static boolean[][] visit = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int N = scanner.nextInt();
            red = scanner.nextInt();
            yellow = scanner.nextInt();
            blue = scanner.nextInt();
            max = 0;
            int[][] types = new int[N][3];
            for (int j = 0; j < N; j++) {
                types[j][0] = scanner.nextInt();
                types[j][1] = scanner.nextInt();
                types[j][2] = scanner.nextInt();
            }
            int[] counts = new int[N];
            visit = new boolean[N][5];
            dfs(0, 0, 0, counts, types);
            System.out.println(max);
        }
    }

    private static void dfs(int r, int y, int b, int[] counts, int[][] types) {
        if (r > red || y > yellow || b > blue || !ok(counts)) {
            max = Math.max(max, getCount(counts) - 1);
            return;
        }
        for (int i = 0; i < counts.length; i++) {
            visit[i][counts[i]] = true;

            counts[i]++;
            if (visit[i][counts[i]]) {
                continue;
            }
            dfs(r + types[i][0], y + types[i][1], b + types[i][2], counts, types);
            visit[i][counts[i]] = false;
            counts[i]--;
        }
    }

    private static boolean ok(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 3) {
                return false;
            }
        }
        return true;
    }

    private static int getCount(int[] counts) {
        int sum = 0;
        for (int i = 0; i < counts.length; i++) {
            sum += counts[i];
        }
        return sum;
    }
}
