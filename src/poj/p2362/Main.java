package poj.p2362;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月17日 16:50:00
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        while (cases-- > 0) {
            int count = scanner.nextInt();
            Integer[] nums = new Integer[count];
            boolean[] visit = new boolean[count];
            int sum = 0;
            for (int i = 0; i < count; i++) {
                nums[i] = scanner.nextInt();
                sum += nums[i];
            }
            if (count < 4 || sum % 4 != 0) {
                System.out.println("no");
                continue;
            }
            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int side = sum / 4;
            if (nums[0] > side) {
                System.out.println("no");
                continue;
            }
            if (dfs(nums, visit, 0, 0, 0, side)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    /**
     *
     * @param nums
     * @param visit
     * @param index
     * @param length
     * @param count 组成的边数
     * @param side
     * @return
     */
    private static boolean dfs(Integer[] nums, boolean[] visit, int index, int length, int count, int side) {
        //组成三个边即可确定能够组成正方形
        if (count == 3) {
            return true;
        }
        for (int i = index; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            if (length + nums[i] < side) {
                if (dfs(nums, visit, i + 1, length + nums[i], count, side)) {
                    return true;
                }
            }
            //可以组成一条边，继续新的
            else if (length + nums[i] == side) {
                if (dfs(nums, visit, 0, 0, count + 1, side)) {
                    return true;
                }
            }
            visit[i] = false;
        }
        return false;
    }

}
