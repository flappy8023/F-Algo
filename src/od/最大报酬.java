package od;

import java.util.Scanner;

public class 最大报酬 {
    /**
     * https://fcqian.blog.csdn.net/article/details/128306650
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] line1 = scanner.nextLine().split(" ");
            int t = Integer.parseInt(line1[0]);
            int n = Integer.parseInt(line1[1]);
            int[] times = new int[n];
            int[] monoy = new int[n];
            for (int i = 0; i < n; i++) {
                String[] arr = scanner.nextLine().split(" ");
                times[i] = Integer.parseInt(arr[0]);
                monoy[i] = Integer.parseInt(arr[1]);
            }
//            int max = backTracking(t, times, monoy, 0);
            int max = bag(t, times, monoy);
            System.out.println(max + "");
        }
    }

    public static int backTracking(int total, int[] time, int[] money, int index) {
        if (index == time.length || total == 0) {
            return 0;
        }
        int choose = 0;
        int unChoose = 0;
        //选择当前工作

        if (total >= time[index])
            choose = money[index] + backTracking(total - time[index], time, money, index + 1);
        //不选择

        unChoose = backTracking(total, time, money, index + 1);

        return Math.max(choose, unChoose);
    }

    public static int bag(int totalTime, int[] time, int[] money) {
        //dp含义 前i项工作在j时间内的最大报酬
        int[][] dp = new int[time.length + 1][totalTime + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= time[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - time[i - 1]] + money[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[time.length][totalTime];
    }


}
