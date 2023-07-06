package leetcode._135Candy;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 贪心
 * @createTime 2023年07月06日 09:18:00
 */
public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        //先从前往后，比较右侧大于左侧
        for (int i = 0; i <= ratings.length - 2; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        //在从后往前，比较左侧大于右侧,
        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }
        int sum = 0;
        //统计总数
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
