package poj.p2531;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月23日 15:04:00
 */
public class Main {
    /**
     * 是否放到了另一个集合1中
     */
    private static boolean[] visit = null;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        visit = new boolean[n];
        visit[0] = true;

        dfs(0, 0, n, nums);
        System.out.println(max);
    }

    //把nums[index]放入另一个集合1中
    private static void dfs(int index, int sum, int n, int[][] nums) {
        visit[index] = true;
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                sum -= nums[i][index];
            } else {
                sum += nums[i][index];
            }
        }
        max = Math.max(max, sum);
        for (int i = index + 1; i < n; i++) {
            dfs(i, sum, n, nums);
            visit[i] = false;
        }


    }

}
