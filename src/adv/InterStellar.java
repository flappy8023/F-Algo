package adv;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName InterSteller.java
 * @Description TODO
 * @createTime 2023年05月23日 16:52:00
 */
public class InterStellar {
    private static int min = 0;
    private static boolean[] visit = null;

    static class WormHole {
        int aX;
        int aY;
        int bX;
        int bY;
        int time;

        public WormHole(int aX, int aY, int bX, int bY, int time) {
            this.aX = aX;
            this.aY = aY;
            this.bX = bX;
            this.bY = bY;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int N = scanner.nextInt();
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            int endX = scanner.nextInt();
            int endY = scanner.nextInt();
            WormHole[] holes = new WormHole[N];
            for (int j = 0; j < N; j++) {
                int aX = scanner.nextInt();
                int aY = scanner.nextInt();
                int bX = scanner.nextInt();
                int bY = scanner.nextInt();
                int time = scanner.nextInt();
                holes[j] = new WormHole(aX, aY, bX, bY, time);
            }
            //1.不用任何虫洞
            min = Math.abs(endY - startY) + Math.abs(startX - endX);
            //2.使用1-N个虫洞
            for (int j = 0; j < holes.length; j++) {
                visit = new boolean[N];
                dfs(startX, startY, endX, endY, holes, 0, j + 1, 0);
            }
            System.out.println("#" + (i + 1) + " " + min);
        }
    }

    private static int getTime(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    /**
     * @param sX
     * @param sY
     * @param eX
     * @param eY
     * @param holes
     * @param time
     * @param num   使用num个虫洞
     */
    private static void dfs(int sX, int sY, int eX, int eY, WormHole[] holes, int time, int num, int step) {
        //大于当前最小时间没有意义
        if (time >= min) {
            return;
        }
        //用够了num个虫洞，记录当前时间
        if (step == num) {
            time += getTime(sX, sY, eX, eY);
            min = Math.min(time, min);
            return;
        }
        for (int i = 0; i < holes.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            //选取虫洞bX,bY作为入口
            dfs(holes[i].aX, holes[i].aY, eX, eY, holes, +time + getTime(sX, sY, holes[i].bX, holes[i].bY) + holes[i].time, num, step + 1);
            //选取虫洞aX,aY作为入口
            dfs(holes[i].bX, holes[i].bY, eX, eY, holes, time + getTime(sX, sY, holes[i].aX, holes[i].aY) + holes[i].time, num, step + 1);
            visit[i] = false;
        }
    }


}
