package od;

import java.util.Arrays;
import java.util.Scanner;

public class 玩牌高手 {
    /**
     * https://fcqian.blog.csdn.net/article/details/127417904
     */
    private static int maxPoint = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        //dp[
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[0] = Math.max(0, nums[0]);
            } else if (i < 3) {
                dp[i] = Math.max(dp[i - 1] + nums[i], 0);
            } else {
                dp[i] = Math.max(dp[i - 1] + nums[i], dp[i - 3]);
            }
        }
        System.out.println(dp[nums.length - 1] + "");
    }


}
