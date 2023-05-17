package poj.p2251;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main1.java
 * @Description TODO
 * @createTime 2023年05月17日 10:44:00
 */
public class Main {
    static int[][] moves = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static int minStep = 0;

    static class Position {
        int level;
        int row;
        int column;
        int step;

        public Position(int l, int r, int c, int s) {
            row = r;
            level = l;
            column = c;
            step = s;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            if (l == 0 && r == 0 && c == 0) {
                return;
            }
            minStep = 0;
            char[][][] dungeon = new char[l][r][c];
            boolean[][][] visit = new boolean[l][r][c];
            int startR = 0, startC = 0, startL = 0;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    char[] letters = scanner.next().toCharArray();
                    for (int k = 0; k < letters.length; k++) {
                        dungeon[i][j][k] = letters[k];
                        if (Objects.equals(letters[k], "S")) {
                            startL = i;
                            startR = j;
                            startC = k;
                        }

                    }
                }
            }
            bsf(dungeon, visit, startL, startR, startC);
            if (minStep == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + minStep + " minute(s).");
            }
        }
    }

    private static void bsf(char[][][] dungeon, boolean[][][] visit, int startL, int startR, int startC) {
        Position[] queue = new Position[100000];
        int head = 0;
        int tail = 0;
        queue[tail++] = new Position(startL, startR, startC, 0);
        while (head < tail) {
            Position p = queue[head++];
            if (dungeon[p.level][p.row][p.column]==('E')) {
                minStep = p.step;
                return;
            }
            for (int i = 0; i < moves.length; i++) {
                int[] move = moves[i];
                Position next = new Position(p.level + move[0], p.row + move[1], p.column + move[2], p.step + 1);
                if (check(next, dungeon, visit)) {
                    queue[tail++] = next;
                    visit[next.level][next.row][next.column] = true;
                }
            }
        }
    }

    private static boolean check(Position position, char[][][] dungeon, boolean[][][] visit) {
        //检查边界
        if (position.level >= dungeon.length || position.level < 0 || position.row >= dungeon[0].length || position.row < 0 || position.column >= dungeon[0][0].length || position.column < 0) {
            return false;
        }
        //是否是石头
        if (dungeon[position.level][position.row][position.column]==('#')) {
            return false;
        }
        //已经访问过
        if (visit[position.level][position.row][position.column]) return false;


        return true;
    }
}
