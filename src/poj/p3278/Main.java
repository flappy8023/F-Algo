package poj.p3278;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月16日 11:06:00
 */
public class Main {

    static class Pos {
        int x;
        int step;

        public Pos(int x, int step) {
            this.x = x;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        boolean[] visit = new boolean[100000];
        Pos[] queue = new Pos[200000];
        int head = 0;
        int tail = 0;
        queue[tail++] = new Pos(n, 0);

        visit[n] = true;
        while (head < tail) {
            Pos pos = queue[head++];
            if (pos.x == k) {
                System.out.println(pos.step);
                return;
            }

            if (!visit[pos.x + 1] && pos.x + 1 <= k) {
                queue[tail++] = (new Pos(pos.x + 1, pos.step + 1));
                visit[pos.x + 1] = true;
            }
            if (!visit[pos.x - 1]) {
                queue[tail++] = (new Pos(pos.x - 1, pos.step + 1));
                visit[pos.x - 1] = true;
            }
            if (!visit[pos.x * 2] && pos.x <= k) {
                queue[tail++] = (new Pos(pos.x * 2, pos.step + 1));
                visit[pos.x * 2] = true;
            }
        }
    }
}
