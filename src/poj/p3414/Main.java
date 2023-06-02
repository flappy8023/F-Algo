package poj.p3414;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月17日 09:37:00
 */
public class Main {
    static class OP {
        //        //记录之前的操作
//        String pre = "";
        //操作描述 FILL(1)
        String operation;
        //i的当前水量
        int v1;
        //j的当前水量
        int v2;
        int step;

        public OP(String operation, int v1, int v2, int step) {
            this.operation = operation;
            this.v1 = v1;
            this.v2 = v2;
            this.step = step;

        }
    }

    private static OP lastOP;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        bfs(a, b, c);
        if (null == lastOP) {
            System.out.println("impossible");
        } else {
            System.out.println(lastOP.step);
            System.out.printf(lastOP.operation);
        }

    }

    private static void bfs(int a, int b, int c) {
        OP[] ops = new OP[100000];
        int head = 0;
        int tail = 0;
        boolean[][] visit = new boolean[a + 1][b + 1];
        ops[tail++] = new OP("", 0, 0, 0);
        visit[a][b] = true;
        while (head < tail) {
            OP op = ops[head++];
            visit[op.v1][op.v2] = true;
            //缸1 或者缸2达到了要求，终止
            if (op.v1 == c || op.v2 == c) {
                //记录最后一个操作
                lastOP = op;
                return;
            }
            //1.FILL(1)
            if (op.v1 < a && !visit[a][op.v2]) {
                ops[tail++] = new OP(op.operation + "FILL(1)" + "\n", a, op.v2, op.step + 1);
            }
            //2.FILL(2)
            if (op.v2 < b && !visit[op.v1][b]) {
                ops[tail++] = new OP(op.operation + "FILL(2)" + "\n", op.v1, b, op.step + 1);
            }
            //3.DROP(1)
            if (op.v1 > 0 && !visit[0][op.v2]) {
                ops[tail++] = new OP(op.operation + "DROP(1)" + "\n", 0, op.v2, op.step + 1);
            }
            //4.DROP(2)
            if (op.v2 > 0 && !visit[op.v1][0]) {
                ops[tail++] = new OP(op.operation + "DROP(2)" + "\n", op.v1, 0, op.step + 1);
            }
            //5.POUR(1,2)
            OP op12 = getPour12(op, b);
            if (op.v1 > 0 && op.v2 < b && !visit[op12.v1][op12.v2]) {
                ops[tail++] = op12;
            }
            //6.POUR(2,1)
            OP op21 = getPour21(op, a);
            if (op.v2 > 0 && op.v1 < a && !visit[op21.v1][op21.v2]) {
                ops[tail++] = op21;
            }
        }
    }

    private static OP getPour12(OP pre, int b) {
        int bNeed = b - pre.v2;
        //缸1的水足够填满缸2
        if (pre.v1 >= bNeed) {
            return new OP(pre.operation + "POUR(1,2)" + "\n", pre.v1 - bNeed, b, pre.step + 1);
        }
        //缸1的水不够填满缸2
        else {
            return new OP(pre.operation + "POUR(1,2)" + "\n", 0, pre.v2 + pre.v1, pre.step + 1);
        }
    }

    private static OP getPour21(OP pre, int a) {
        int aNeed = a - pre.v1;
        if (pre.v2 >= aNeed) {
            return new OP(pre.operation + "POUR(2,1)" + "\n", a, pre.v2 - aNeed, pre.step + 1);
        } else {
            return new OP(pre.operation + "POUR(2,1)" + "\n", pre.v1 + pre.v2, 0, pre.step + 1);
        }
    }
}
