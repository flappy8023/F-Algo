package od;

import java.util.Arrays;
import java.util.Scanner;

public class 叠积木 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            int n = nums.length;
            if (n == 1) {
                System.out.println(1);
                return;
            }
            if (n == 2) {
                System.out.println(nums[0] == nums[1] ? 2 : 1);
                return;
            }
            //每一层最小长度 ：最长的一块
            int min = nums[n - 1];
            //每一块最长长度 ：两块组合起来，最大只能是最短加最长
            int max = nums[0] + min;
            //区间内逐个尝试
            for (int len = min; len <= max; len++) {
                int ans = 0;
                int left = 0;
                int right = n - 1;
                //最长的可以单独一层
                while (right >= 0 && nums[right] == len) {
                    right--;
                    ans++;
                }
                while (left<right&&nums[left]+nums[right]==len){
                    left++;
                    right--;
                    ans++;
                }
                //正常结束，left》right
                if(left<=right)continue;
                System.out.println(ans);
                return;
            }
            System.out.println(-1);
        }

    }
}
