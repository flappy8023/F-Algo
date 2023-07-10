package leetcode._56MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月07日 14:41:00
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        //按照区间左侧下标进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            //两个区间不重叠，保存上一个区间到结果中，更新下一个区间的起始位置
            if (intervals[i][0] > end) {

                result[count][0] = start;
                result[count][1] = end;
                count++;
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                //两个区间重叠，更新区间最右侧下标
                end = Math.max(end, intervals[i][1]);
            }
        }
        result[count][0] = start;
        result[count][1] = end;
        count++;
        return Arrays.copyOf(result, count);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[][]{{1, 4}, {2, 3}});
    }
}
