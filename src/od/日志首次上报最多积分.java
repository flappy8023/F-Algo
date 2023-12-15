package od;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class 日志首次上报最多积分 {
    public static void main(String[] args) {
        /**
         * https://fcqian.blog.csdn.net/article/details/128228398
         */

        /**
         *    0 1 2 3 4
         *  0
         *  1
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            Integer[] arr = Arrays.stream(input.split(" ")).map(new Function<String, Integer>() {
                @Override
                public Integer apply(String s) {
                    return Integer.parseInt(s.trim());
                }
            }).toArray(Integer[]::new);
            //记录正向得分
            int[] dp = new int[arr.length];
            dp[0] = arr[0];
            //记录延迟上报扣分
            int[] delay = new int[arr.length];
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                //最大上传100条
                dp[i] = Math.min(100, dp[i - 1] + arr[i]);
                delay[i] = dp[i - 1] + delay[i - 1];
                max = Math.max(max, dp[i] - delay[i]);
                if(dp[i]>=100)break;
            }
            System.out.println(max + "");
        }
    }
}
