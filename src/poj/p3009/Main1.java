package poj.p3009;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main1.java
 * @Description TODO
 * @createTime 2023年05月23日 09:31:00
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            if (w == 0 && h == 0) return;
            int[][] board = new int[h][w];
            boolean[][] visit = new boolean[h][w];
            Square start = null;
            int endX = 0, endY = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    board[i][j] = scanner.nextInt();
                    //记录起点位置
                    if (board[i][j] == 2) {
                        start = new Square(j, i, 0, board);
                        visit[i][j] = true;
                    }
                    //记录终点
                    if (board[i][j] == 3) {
                        endY = i;
                        endX = j;
                    }

                }
            }
            Square[] queue = new Square[100_0000];
            bfs(visit, start, endX, endY, queue);

        }
    }

    private static void bfs(boolean[][] visit, Square start, int endX, int endY, Square[] queue) {
        int head = 0, tail = 0;
        queue[tail++] = start;
        while (head < tail) {
            Square square = queue[head++];
            if (square.x == endX && square.y == endY) {
                System.out.println(square.move);
                return;
            }
            if (square.move == 10) {
                System.out.println(-1);
                return;
            }
            //向上
            Square up = getUp(square.board, square);
            if (null != up /*&& !visit[up.y][up.x]*/) {
                queue[tail++] = up;
                visit[up.y][up.x] = true;
            }
            //向下
            Square down = getDown(square.board, square);
            if (null != down /*&& !visit[down.y][down.x]*/) {
                queue[tail++] = down;
                visit[down.y][down.x] = true;
            }
            //向左
            Square left = getLeft(square.board, square);
            if (null != left/* && !visit[left.y][left.x]*/) {
                queue[tail++] = left;
                visit[left.y][left.x] = true;
            }
            //向右
            Square right = getRight(square.board, square);
            if (null != right /*&& !visit[right.y][right.x]*/) {
                queue[tail++] = right;
                visit[right.y][right.x] = true;
            }
        }
        System.out.println(-1);
    }

    private static Square getUp(int[][] b, Square square) {
        int[][] board = copy(b);
        for (int i = square.y - 1; i >= 0; i--) {
            //空地滑行
            if (board[i][square.x] == 0) {
                //滑出场地
                if (i == 0) {
                    return null;
                }
            } else if (board[i][square.x] == 1) {//撞上石头
                if (i == square.y - 1) return null;
                board[i][square.x] = 0;
                return new Square(square.x, i + 1, square.move + 1, board);
            } else if (board[i][square.x] == 3) {
                return new Square(square.x, i, square.move + 1, board);
            }
        }
        return null;
    }

    private static Square getDown(int[][] b, Square square) {
        int[][] board = copy(b);
        for (int i = square.y + 1; i < board.length; i++) {
            if (board[i][square.x] == 0) {
                if (i == board.length - 1) {
                    return null;
                }
            } else if (board[i][square.x] == 1) {
                if (i == square.y + 1) return null;
                board[i][square.x] = 0;
                return new Square(square.x, i - 1, square.move + 1, board);
            } else if (board[i][square.x] == 3) {
                return new Square(square.x, i, square.move + 1, board);
            }
        }
        return null;
    }

    private static Square getLeft(int[][] b, Square square) {
        int[][] board = copy(b);
        for (int i = square.x - 1; i >= 0; i--) {
            if (board[square.y][i] == 0) {
                if (i == 0) {
                    return null;
                }
            } else if (board[square.y][i] == 1) {
                if (i == square.x - 1) return null;
                board[square.y][i] = 0;
                return new Square(i + 1, square.y, square.move + 1, board);
            } else if (board[square.y][i] == 3) {
                return new Square(i, square.y, square.move + 1, board);
            }
        }
        return null;
    }

    private static Square getRight(int[][] b, Square square) {
        int[][] board = copy(b);
        for (int i = square.x + 1; i < board[0].length; i++) {
            if (board[square.y][i] == 0) {
                if (i == board[0].length - 1) {
                    return null;
                }
            } else if (board[square.y][i] == 1) {
                if (i == square.x + 1) return null;
                board[square.y][i] = 0;
                return new Square(i - 1, square.y, square.move + 1, board);
            } else if (board[square.y][i] == 3) {
                return new Square(i, square.y, square.move + 1, board);
            }
        }
        return null;
    }


    static class Square {
        int x;
        int y;
        int move;
        int[][] board;

        public Square(int x, int y, int move, int[][] board) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.board = board;
        }
    }

    private static int[][] copy(int[][] b) {
        int[][] board = new int[b.length][b[0].length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                board[i][j] = b[i][j];
            }
        }
        return board;
    }
}
