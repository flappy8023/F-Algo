package leetcode._452MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 贪心
 * @createTime 2023年07月06日 22:41:00
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        //按照start进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //防止越界
                return Integer.compare(o1[0], o2[0]);
            }
        });
        //不为空，至少需要一根箭
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            //当前气球的start与上一个气球的end不重叠，则需要一只箭
            if (points[i][0] > points[i - 1][1]) {
                result++;
            } else {
                //更新重叠气球的end,取较小的end
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return result;
    }
}
