package od;

import java.util.Scanner;

public class 查找重复代码 {
    /**
     * https://fcqian.blog.csdn.net/article/details/128378675
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            int maxLength = 0;
            int maxIndex = 0;
            //1.dp数组含义 字符串1中0-i个字符和字符串2中0-j个字符最长公共子串
            int[][] dp = new int[line1.length() + 1][line2.length() + 1];
            //2.确定递推公式
            // if(line1[i]==line2[j]) dp[i][j] = dp[i-1][j-1]+1
            //3.初始化dp数组
            for (int i = 0; i < line1.length(); i++) {
                for (int j = 0; j < line2.length(); j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    }
                }
            }
            //4.遍历顺序 正向
            //5.举例验证dp
            for (int i = 1; i <= line1.length(); i++) {
                for (int j = 1; j <= line2.length(); j++) {
                    if (line1.charAt(i - 1) == line2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        maxIndex = i;
                    }

                }
            }
            if (maxIndex > 0 && maxIndex >= maxLength) {
                System.out.println(line1.substring(maxIndex - maxLength, maxIndex));
            } else {
                System.out.println("");
            }


        }
    }
}
