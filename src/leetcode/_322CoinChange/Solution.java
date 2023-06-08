package leetcode._322CoinChange;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年05月19日 17:13:00
 */
public class Solution {
    class Change {
        int count;
        int sum;

        public Change(int c, int s) {
            count = c;
            sum = s;
        }
    }

    public int coinChange(int[] coins, int amount) {
        Change[] queue = new Change[100000];
        int head = 0, tail = 0;
        queue[tail++] = new Change(0, 0);
        boolean[] visit = new boolean[amount + 1];
        Arrays.sort(coins);
        int[] arr = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            arr[coins.length - 1 - i] = coins[i];
        }
        while (head < tail) {
            Change change = queue[head++];
            if (change.sum == amount) {
                return change.count;
            }
            for (int i = 0; i < arr.length; i++) {
                if (change.sum + arr[i] <= amount && !visit[change.sum + arr[i]]) {
                    queue[tail++] = new Change(change.count + 1, change.sum + arr[i]);
                    visit[change.sum + arr[i]] = true;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.coinChange(new int[]{1, 2, 5}, 11);
    }
}
