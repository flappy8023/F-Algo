package poj.p1416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月18日 18:03:00
 */
public class Main {
    private static int max = 0;
    private static int[] finalResult;
    private static boolean moreThanOne = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int target = scanner.nextInt();
            int input = scanner.nextInt();
            if (target == 0 && input == 0) return;
            int[] temps = new int[100000];
            int digits = 0;
            while (input > 0) {
                temps[digits++] = input % 10;
                input /= 10;
            }
            int[] nums = new int[digits];
            for (int i = 0; i < digits; i++) {
                nums[digits - 1 - i] = temps[i];
            }
            int[] tempResult = new int[digits];
            finalResult = new int[digits];
            max = 0;
            for (int i = 0; i < finalResult.length; i++) {
                tempResult[i] = -1;
            }
            dfs(nums, 0, nums.length, target, 0, tempResult);
            if (max > 0) {
                if (moreThanOne) {
                    System.out.println("rejected");
                } else {
                    System.out.print(max);
                    for (int i = 0; i < finalResult.length; i++) {
                        if (finalResult[i] != -1)
                            System.out.printf(" " + finalResult[i]);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("error");
            }
        }
    }

    /**
     * @param nums
     * @param target
     */
    private static void dfs(int[] nums, int startIndex, int length, int target, int sum, int[] temp) {
        if (sum > target) return;
        if (startIndex == nums.length) {
            if (sum > max) {
                max = sum;
                moreThanOne = false;
                finalResult = Arrays.copyOf(temp, temp.length);

            } else if (sum == max) {
                moreThanOne = true;

            }
            return;
        }
        for (int i = 1; i <= length; i++) {
            int num = getSum(nums, startIndex, i);
            if (num > target) {
                continue;
            }
            temp[startIndex] = num;
            dfs(nums, startIndex + i, length - i, target, sum + num, temp);
            temp[startIndex] = -1;
        }
    }

    private static int getSum(int[] nums, int index, int length) {
        int sum = 0;
        for (int i = index; i < index + length; i++) {
            sum = sum * 10 + nums[i];
        }
        return sum;
    }
}
