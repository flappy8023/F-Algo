package leetcode._51N_Queens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月04日 10:24:00
 */
public class Solution {
    //皇后所在的位置，下标i为第i行，positions[i]为所在列
    private int[] positions = new int[9];
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backTracking(0, n);
        return result;

    }

    private void backTracking(int rowIndex, int n) {
        if (rowIndex == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < rowIndex; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < rowIndex; j++) {
                    if (positions[i] == j) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                list.add(builder.toString());
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(rowIndex, i)) {
                positions[rowIndex] = i;
                backTracking(rowIndex + 1, n);
                positions[rowIndex] = 0;
            }
        }
    }

    private boolean isValid(int row, int column) {
        //判断当前位置与之前选定的位置是否合法
        for (int i = 0; i < row; i++) {
            //同列
            if (positions[i] == column) return false;
                //对角线
            else if (Math.abs(i - row) == Math.abs(positions[i] - column)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
    }
}
