package poj.p2251;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description 3D迷宫 http://poj.org/problem?id=2251
 * @createTime 2023年05月10日 18:12:00
 */
public class Main {
    private static char[][][] dungeon ;
    private static boolean[][][] vis ;
    private static int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0},
            {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    private static MyPoint start, end;
    private static int result = -1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int levels = scanner.nextInt();
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            if (levels == 0 && rows == 0 && columns == 0) {
                return;
            }
            dungeon = new char[levels][rows][columns];
            vis = new boolean[levels][rows][columns];
            for (int l = 0; l < levels; l++) {
                for (int r = 0; r < rows; r++) {
                    dungeon[l][r] = scanner.next().toCharArray();
                    for (int c = 0; c < dungeon[l][r].length; c++) {
                        char cr = dungeon[l][r][c];
                        if (cr == 'S') {
                            start = new MyPoint(l, r, c, 0);
                        }
                        if (cr == 'E') {
                            end = new MyPoint(l, r, c, 0);
                        }
                    }
                }
            }
            result = -1;
            bfs(levels, rows, columns);
            if (result > -1) {
                System.out.println("Escaped in " + result + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }

        }

    }

    static void bfs(int levels, int rows, int colums) {
        LinkedList<MyPoint> queue = new LinkedList();
        queue.add(start);
        vis[start.level][start.row][start.column] = true;
        while (!queue.isEmpty()) {
            MyPoint p = queue.poll();
            if (p.level == end.level && p.row == end.row
                    && p.column == end.column) {
                result = p.step;
                return;
            }
            for (int i = 0; i < dirs.length; i++) {
                MyPoint next = new MyPoint(p.level + dirs[i][0],
                        p.row + dirs[i][1], p.column + dirs[i][2], p.step + 1);
                if (check(next, levels, rows, colums)) {
                    queue.offer(next);
                    vis[next.level][next.row][next.column] = true;


                }
            }

        }
    }

    static boolean check(MyPoint p, int level, int row, int column) {

        if (p.level < 0 || p.level >= level) {
            return false;
        }
        if (p.row < 0 || p.row >= row) {
            return false;
        }
        if (p.column < 0 || p.column >= column) {
            return false;
        }
        if (vis[p.level][p.row][p.column]) {
            return false;
        }
        if (dungeon[p.level][p.row][p.column] == '#') {
            return false;
        }
        return true;
    }


}

class MyPoint {
    int level;
    int row;
    int column;
    int step;

    public MyPoint(int l, int r, int c, int s) {
        level = l;
        row = r;
        column = c;
        step = s;
    }

}