package leetcode._435Non_OverLappingIntervals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 贪心
 * @createTime 2023年07月07日 09:35:00
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //按照区间左侧位置排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int result = 1;
        //类似452：用最小数量的箭引爆气球,最小数量的箭相当于最多不重叠的区间数量，只不过这边区间边缘可以相等
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]) {
                result++;
            } else {
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return intervals.length - result;
    }
}
