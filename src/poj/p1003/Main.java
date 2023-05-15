package poj.p1003;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月14日 15:02:00
 */
public class Main {
    public static void main(String[] args) {
//        //1.dp数组含义 n张卡片能超出的长度
//        //2.递推关系 dp[i] = dp[i-1]+1/(i+1)
//        //3.初始化dp数组  dp[0]=1/2
//        //4.确定遍历顺序
//        //5.举例推导
//        double[] dp = new double[520];
//        dp[0] = 1 / 2d;
//        for (int i = 1; i < 520; i++) {
//            dp[i] = dp[i - 1] + 1d / (i + 2);
//        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double it = scanner.nextDouble();
            if (it == 0.00) return;
            System.out.println(find(it) + " card(s)");
        }
    }

    private static int find(double target/*, double[] dp*/) {
//        for (int i = 0; i < dp.length; i++) {
//            if (dp[i] >= target) {
//                return i + 1;
//            }
//        }
//        return -1;
        double sum = 0.00;
        int i = 2;
        while (sum < target) {
            sum += 1d / i++;
        }
        return i - 2;
    }
}
