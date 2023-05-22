package poj.p1426;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月22日 14:20:00
 */
public class Main {
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) return;
            flag = false;
//            dfs(n, 1, 1);
            bfs(n);
        }
    }

    private static void dfs(int n, long value, int count) {
        if (flag) return;
        if (value % n == 0) {
            flag = true;
            System.out.println(value);
            return;
        }
        if (count == 18) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            dfs(n, value * 10 + i, count + 1);
        }

    }

    private static void bfs(int n) {
        OP[] ops = new OP[1000000];
        int head = 0, tail = 0;
        ops[tail++] = new OP(1, 1);
        while (head < tail) {
            OP op = ops[head++];
            if (op.value % n == 0) {
                System.out.println(op.value);
                break;
            }
            ops[tail++] = new OP(op.value * 10, op.count + 1);
            ops[tail++] = new OP(op.value * 10 + 1, op.count + 1);
        }
    }

    static class OP {
        int count;
        int value;

        public OP(int v, int c) {
            this.count = c;
            this.value = v;
        }
    }
}
