package poj.p3009;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月15日 23:02:00
 */
public class Main {
    static int movement = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int colums = scanner.nextInt();
            int row = scanner.nextInt();
            if (colums == 0 && row == 0) return;
            int[][] nums = new int[row][colums];
            int startColum = 0, startRow = 0, endColumn = 0, endRow = 0;
            movement = -1;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < colums; j++) {
                    nums[i][j] = scanner.nextInt();
                    if (nums[i][j] == 2) {
                        startColum = j;
                        startRow = i;
                    }
                    if (nums[i][j] == 3) {
                        endColumn = j;
                        endRow = i;
                    }
                }
            }
            nums[startRow][startColum] = 0;
            dfs(startColum, startRow, endColumn, endRow, 0, nums);
            System.out.println(movement);

        }
    }


    static void dfs(int startColumn, int startRow, int endColumn, int endRow, int step, int[][] nums) {
        //超过十次输了
        if (step > 10) {
            return;
        }
        if (startColumn == endColumn && startRow == endRow) {
            if (movement == -1) {
                movement = step;
            } else {
                movement = Math.min(movement, step);
            }
            return;
        }
        if (!check(nums, startRow, startColumn)) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            MoveResult result = null;
            //0向上扔
            if (i == 0) {
                result = up(nums, startRow, startColumn);
            }
            //1向下扔
            if (i == 1) {
                result = down(nums, startRow, startColumn);
            }
            //2向左扔
            if (i == 2) {
                result = left(nums, startRow, startColumn);
            }
            //3向右扔
            if (i == 3) {
                result = right(nums, startRow, startColumn);
            }
            if (null == result) continue;
            if (result.blockRow != -1 && result.blockColumn != -1) {
                nums[result.blockRow][result.blockColumn] = 0;
            }

            dfs(result.column, result.row, endColumn, endRow, step + 1, nums);
            //还原撞碎的石头
            if (-1 != result.blockColumn && -1 != result.blockRow) {
                nums[result.blockRow][result.blockColumn] = 1;
            }
        }
    }

    private static boolean check(int[][] nums, int startRow, int startColumn) {
        return startColumn < nums[0].length && startRow < nums.length && startRow >= 0 && startColumn >= 0;
    }

    private static MoveResult up(int[][] nums, int row, int column) {

        for (int i = row - 1; i >= 0; i--) {
            if (nums[i][column] == 1) {
                //紧邻石头的方向不能移动

                if (i == row - 1) return null;

                return new MoveResult(i + 1, column, i, column);
            }
            if (nums[i][column] == 3) {
                return new MoveResult(i, column, -1, -1);
            }
        }
        return null;
    }

    private static MoveResult down(int[][] nums, int row, int column) {
        for (int i = row + 1; i < nums.length; i++) {
            //紧邻石头的方向不能移动

            if (nums[i][column] == 1) {
                if (i == row + 1) return null;

                return new MoveResult(i - 1, column, i, column);
            }
            if (nums[i][column] == 3) {
                return new MoveResult(i, column, -1, -1);
            }
        }
        return null;
    }

    private static MoveResult left(int[][] nums, int row, int column) {
        for (int i = column - 1; i >= 0; i--) {
            if (nums[row][i] == 1) {
                //紧邻石头的方向不能移动

                if (i == column - 1) return null;
                return new MoveResult(row, i + 1, row, i);
            }
            if (nums[row][i] == 3) {
                return new MoveResult(row, i, -1, -1);
            }
        }
        return null;
    }

    private static MoveResult right(int[][] nums, int row, int column) {
        for (int i = column + 1; i < nums[0].length; i++) {
            if (nums[row][i] == 1) {
                //紧邻石头的方向不能移动

                if (i == column + 1) return null;

                return new MoveResult(row, i - 1, row, i);
            }
            if (nums[row][i] == 3) {
                return new MoveResult(row, i, -1, -1);
            }
        }
        return null;
    }

    static class MoveResult {
        int row;
        int column;
        int blockRow;
        int blockColumn;

        public MoveResult(int r, int c, int bR, int bC) {
            row = r;
            column = c;
            blockColumn = bC;
            blockRow = bR;
        }
    }
}
