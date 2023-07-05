package leetcode._1005MaximizeSumOfArrayAfterKNegations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月05日 15:21:00
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //按绝对值从大到小进行排序
        Integer[] temps = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temps[i] = nums[i];
        }
        Arrays.sort(temps, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2) - Math.abs(o1);
            }
        });
        //优先把负数反转为正数
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] < 0 && k > 0) {
                temps[i] = -temps[i];
                k--;
            }
        }
        //剩下的k如果是奇数，就把最后一个元素变成负数
        if (k % 2 == 1) temps[temps.length - 1] *= -1;
        int sum = 0;
        for (int i = 0; i < temps.length; i++) {
            sum += temps[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.largestSumAfterKNegations(new int[]{2, -3, -1, 5, 4}, 2);
    }
}
