package leetcode._202HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月12日 10:40:00
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        do {
            set.add(n);
            n = calculateN(n);
        } while (n != 1 && !set.contains(n));
        return n == 1;

    }

    private int calculateN(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isHappy(19);
    }
}
