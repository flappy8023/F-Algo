package leetcode._059SpiralMatrixII;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月08日 16:25:00
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        //每一圈的结束下标（以行或者列来看）
        int fn = n - 1;
        //每一圈的开始下标（以行或者列来看）
        int sn = 0;
        //用来填充的数字
        int num = 1;

        int[][] matrix = new int[n][n];
        //从外向内，一圈一圈填充，直到变成一个点
        while (sn <= fn) {
            //填充上方的边，从左往右
            for (int i = sn; i <= fn; i++) {
                matrix[sn][i] = num++;
            }
            //填充右方的边，从上往下，不包含与上边的交点
            for (int i = sn + 1; i <= fn; i++) {
                matrix[i][fn] = num++;
            }
            //填充下方的边，从右往左，不包含与右边的交点
            for (int i = fn - 1; i >= sn; i--) {
                matrix[fn][i] = num++;
            }
            //填充左方的边，从下往上，不包含与上边和下边的交点
            for (int i = fn - 1; i > sn; i--) {
                matrix[i][sn] = num++;
            }
            //填充完一圈后，圈向内缩小
            fn -= 1;
            sn += 1;
        }
        return matrix;
    }

}
