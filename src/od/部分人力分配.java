package od;

import java.util.Arrays;
import java.util.Scanner;

public class 部分人力分配 {
    /**
     * https://blog.csdn.net/qfc_128220/article/details/134724995?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22134724995%22%2C%22source%22%3A%22qfc_128220%22%7D
     *
     * @param args
     *
     * 二分+双指针
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        long[] requirements = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
        //工作量最大的需求单独一个月，此时单月人力最小
        long min = requirements[requirements.length - 1];
        //工作量最大的需求和次大的需求放在同一个月，此时单月人力最大
        long max = 0;
        if (requirements.length > 1) {
            max = requirements[requirements.length - 1] + requirements[requirements.length - 2];
        } else {
            max = requirements[0];
        }
        long ans = max;
        while (min <= max) {
            long mid = (min + max) / 2;
            if (check(m, requirements, mid)) {
                ans = mid;
                max = mid - 1;

            } else {
                min = mid + 1;
            }
        }
        System.out.println(ans + "");
    }

    public static boolean check(int m, long[] requirements, long limit) {
        //l指向工作量最小的
        int l = 0;
        //r指向工作量最大的
        int r = requirements.length - 1;
        int month = 0;
        while (l <= r) {
            //最大最小可以放在一个月里的话
            if (requirements[l] + requirements[r] <= limit) {
                l++;
                r--;
                month++;
            } else {
                month++;
                r--;
            }
        }
        //返回能否在指定月数m内完成
        return month <= m;

    }
}
