package poj.p3579;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月12日 14:18:00
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            int[] nums = new int[count];
            for (int i = 0; i < count; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            //插值列表的中间下标
            int d_mid = (count * (count - 1)) >> 2;
            int left = 0;
            int right = nums[count - 1] - nums[0];
            while (left <= right) {
                int mid = (left + right) >> 1;
//                if()
            }
        }
    }

    /**
     * mid是否选大了，如果差值大于mid的数量大于了d_mid,说明mid选小了
     * @param mid
     * @return
     */
//    private static boolean midOk(int mid,int count,int d_mid){
//        int c = 0;
//        for (int i = 0  ; i <count ; i++) {
//            for (int j=i+1;j<count;j++){
//                if()
//            }
//        }
//        return
//    }
}