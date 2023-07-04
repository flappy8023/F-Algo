package leetcode._37SudokuSolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月04日 11:19:00
 */
public class Solution {
    /**
     * 记录每一行中数字1-9使用情况
     */
    private boolean[][] rowsUsed = new boolean[9][10];
    /**
     * 记录每一列中数字1-9使用情况
     */
    private boolean[][] columnUsed = new boolean[9][10];
    /**
     * 记录9个3*3格子中数字1-9的使用情况
     */
    private boolean[][] gridUsed = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        //保存需要需要填充的格子的位置信息
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowsUsed[i][num] = true;
                    columnUsed[j][num] = true;
                    //当前格子所属的九宫格下标
                    int grid = (i / 3) * 3 + (j / 3);
                    gridUsed[grid][num] = true;
                } else {
                    points.add(new Point(i, j));
                }
            }
        }
        backTracking(board, points, 0);
    }

    private boolean backTracking(char[][] board, List<Point> points, int startIndex) {
        if (startIndex == points.size()) {
            return true;
        }
        Point point = points.get(startIndex);
        int i = point.r;
        int j = point.c;
        int grid = (i / 3) * 3 + (j / 3);
        //分别用1-9进行填充
        for (int k = 1; k <= 9; k++) {
            //只有当行、列、小九宫格中都没使用过当前数字才能进行填充
            if (!rowsUsed[i][k] && !columnUsed[j][k] && !gridUsed[grid][k]) {
                board[i][j] = (char) ('0' + k);
                rowsUsed[i][k] = true;
                columnUsed[j][k] = true;
                gridUsed[grid][k] = true;

                if (backTracking(board, points, startIndex + 1)) {
                    return true;
                }
                board[i][j] = '.';
                rowsUsed[i][k] = false;
                columnUsed[j][k] = false;
                gridUsed[grid][k] = false;

            }
        }

//        }
        return false;
    }

    class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        Solution solution = new Solution();
        solution.solveSudoku(board);
    }
}
