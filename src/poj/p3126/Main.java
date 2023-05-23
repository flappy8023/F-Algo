package poj.p3126;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月16日 16:42:00
 */
public class Main {
    static int min = Integer.MAX_VALUE;
    static boolean[] primes = null;

    static class Move {
        int step;
        int value;

        public Move(int step, int value) {
            this.step = step;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        primes = generatePrimes();
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            min = Integer.MAX_VALUE;
            int start = scanner.nextInt();
            int target = scanner.nextInt();
            bfs(start, target);
            if (min == Integer.MAX_VALUE) {
                System.out.println("Impossible");
            } else {
                System.out.println(min);
            }
        }
    }

    private static void bfs(int num, int target) {

        Move[] moves = new Move[100000];
        boolean[] visit = new boolean[10000];
        int head = 0;
        int tail = 0;
        moves[tail++] = new Move(0, num);
        visit[num] = true;
        while (head < tail) {
            Move move = moves[head++];

            if (move.value == target) {
                min = move.step;
                return;
            }
            int temp = move.value;
            int[] digs = new int[4];
            digs[0] = temp / 1000;
            temp = temp % 1000;
            digs[1] = temp / 100;
            temp = temp % 100;
            digs[2] = temp / 10;
            temp = temp % 10;
            digs[3] = temp;
            //转个位,个位只能是奇数
            for (int i = 1; i < 10; i = i + 2) {
                int n = digs[0] * 1000 + digs[1] * 100 + digs[2] * 10 + i;
                if (!visit[n] && isPrime(n)) {
                    moves[tail++] = new Move(move.step + 1, n);
                    visit[n] = true;
                }
            }
            //转十位，没什么限制
            for (int i = 0; i < 10; i++) {
                int n = digs[0] * 1000 + digs[1] * 100 + i * 10 + digs[3];
                if (!visit[n] && isPrime(n)) {
                    moves[tail++] = new Move(move.step + 1, n);
                    visit[n] = true;

                }
            }
            //转百位，没什么限制
            for (int i = 0; i < 10; i++) {
                int n = digs[0] * 1000 + i * 100 + digs[2] * 10 + digs[3];
                if (!visit[n] && isPrime(n)) {
                    moves[tail++] = new Move(move.step + 1, n);
                    visit[n] = true;

                }
            }
            //转千位，不能为0
            for (int i = 1; i < 10; i++) {
                int n = i * 1000 + digs[1] * 100 + digs[2] * 10 + digs[3];
                if (!visit[n] && isPrime(n)) {
                    moves[tail++] = new Move(move.step + 1, n);
                    visit[n] = true;

                }
            }
        }

    }


    private static boolean isPrime(int num) {
//        if (num <= 1) {
//            return false;
//        } else if (num == 2) {
//            return true;
//        } else if (num % 2 == 0) {
//            return true;
//        } else {
//            for (int i = 3; i < num; i++) {
//                if (num % i == 0) {
//                    return false;
//                }
//
//            }
//        }
//        return true;
        return primes[num];
    }

    private static boolean[] generatePrimes() {
        boolean[] primes = new boolean[10000];
        for (int i = 2; i < 10000; i++) {
            boolean isPrime = true;
            for (int j = 2; j <i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            primes[i] = isPrime;
        }
        return primes;
    }
}
