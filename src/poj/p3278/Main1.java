package poj.p3278;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main1.java
 * @Description TODO
 * @createTime 2023年05月22日 17:59:00
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        boolean[] visit = new boolean[100000];
        Move[] moves = new Move[1000000];
        int head = 0, tail = 0;
        moves[tail++] = new Move(n, 0);
        while (head < tail) {
            Move move = moves[head++];
            if (move.x < 0 || move.times > Math.abs(n - k) || move.x > (Math.max(k, n) + 1) * 2) {
                continue;
            }
            if (move.x == k) {
                System.out.println(move.times);
                return;
            }
            if (!visit[move.x + 1]) {
                moves[tail++] = new Move(move.x + 1, move.times + 1);
                visit[move.x + 1] = true;
            }
            if (!visit[move.x - 1]) {
                moves[tail++] = new Move(move.x
                        - 1, move.times + 1);
                visit[move.x - 1] = true;
            }
            if (!visit[move.x * 2]) {
                moves[tail++] = new Move(move.x * 2, move.times + 1);
                visit[move.x * 2] = true;
            }
        }

    }

    static class Move {
        int x;
        int times;

        public Move(int x, int t) {
            this.x = x;
            times = t;
        }
    }
}
