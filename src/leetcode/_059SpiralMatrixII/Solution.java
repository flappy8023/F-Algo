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
        //每一圈的结束下标
        int fn = n - 1;
        //每一圈的开始下标
        int sn = 0;
        int num = 1;

        int[][] matrix = new int[n][n];
        while (sn <= fn) {
            //上
            for (int i = sn; i <= fn; i++) {
                matrix[sn][i] = num++;
            }
            //右
            for (int i = sn + 1; i <= fn; i++) {
                matrix[i][fn] = num++;
            }
            //下
            for (int i = fn - 1; i >= sn; i--) {
                matrix[fn][i] = num++;
            }
            //左
            for (int i = fn - 1; i > sn; i--) {
                matrix[i][sn] = num++;
            }
            fn -= 1;
            sn += 1;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] res = new Solution().generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(res[i]));

        }
    }
}
