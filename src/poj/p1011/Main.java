package poj.p1011;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月18日 16:15:00
 */
public class Main {
    static int minOrigin = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num == 0) return;
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int[] nums = new int[num];
            int sum = 0;
            for (int i = 0; i < num; i++) {
                nums[i] = arr[num - 1 - i];
                sum += nums[i];
            }
            int target = nums[0];
            //最小原始长度在目前已有的最大长度和总减去最大长度之间,默认目前最长的作为原始长度
            for (int i = target; i <= sum - target; i++) {
                boolean[] visit = new boolean[num];
                //剪枝，原始长度肯定总长度的约数
                if (sum % i != 0) continue;
                if (dfs(i, nums, visit, 0)) {
                    System.out.println(i);
                    break;
                }
            }

        }
    }

    /**
     * @param target   原始长度
     * @param nums
     * @param visit
     * @param groupSum 当前分组的总长度
     * @return
     */
    private static boolean dfs(int target, int[] nums, boolean[] visit, int groupSum) {
        if (groupSum == 0 && allUsed(visit)) {
            return true;
        }
        int unable = -1;
        for (int i = 0; i < nums.length; i++) {
            //剪枝，只能用一次
            if (visit[i]) continue;
            //剪枝，相同长度的树枝上次不行这次肯定也不行
            if (unable == nums[i]) continue;
            visit[i] = true;
            if (groupSum + nums[i] < target) {

                if (dfs(target, nums, visit, groupSum + nums[i])) {
                    return true;
                } else {
                    unable = nums[i];
                }
            } else if (groupSum + nums[i] == target) {
                if (dfs(target, nums, visit, 0)) {
                    return true;
                } else {
                    unable = nums[i];
                }
            }
            visit[i] = false;
        }
        return false;
    }

    private static boolean allUsed(boolean[] visit) {
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) return false;
        }
        return true;
    }
}
