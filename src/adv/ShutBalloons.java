package adv;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName ShutBalloons.java
 * @Description TODO
 * @createTime 2023年05月26日 17:23:00
 */
public class ShutBalloons {
    static int[] balloons;
    static int maxScore = 0;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            N = scanner.nextInt();
            balloons = new int[N];
            for (int j = 0; j < N; j++) {
                balloons[j] = scanner.nextInt();
            }
            for (int index = 0; index < balloons.length; index++) {
                int temp = balloons[index];
                balloons[index] = 0;
                dfs(1, getScore(index,temp));
                balloons[index] = temp;
            }
            System.out.println("#" + (i + 1) + ":" + maxScore);
        }
    }

    private static void dfs( int step, int score) {
        if (step == N) {
            maxScore = Math.max(score, maxScore);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (balloons[i] == 0) continue;
            int temp = balloons[i];
            balloons[i] = 0;
            dfs( step + 1, score + getScore(i,temp));
            balloons[i] = temp;
        }
    }

    private static int getScore(int index,int origin) {
        //左边有没有气球
        int left = index - 1;
        boolean lf = false;
        while (left >= 0) {

            if (balloons[left] != 0) {
                lf = true;
                break;
            }
            left--;
        }
        //右边有没有气球
        int right = index + 1;
        boolean rf = false;
        while (right < N) {
            if (balloons[right] != 0) {
                rf = true;
                break;
            }
            right++;
        }
        if (lf && rf) {
            return balloons[left] * balloons[right];
        } else if (!lf && !rf) {
            return origin;
        } else if (lf) {
            return balloons[left];
        } else {
            return balloons[right];
        }
    }
}
