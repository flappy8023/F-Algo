package base.sort;

import java.util.Arrays;

/**
 * 选择排序，找出数组中最小的放到左边，从剩余部分继续重复
 * 时间复杂度O(n^2) 空间复杂度O(1)
 */
public class SelectionSort extends Sort {
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            //从数组剩余部分取到最小值
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[min]) {
                    min = j;
                }
            }
            //把最小值放到左边
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 23, 4, 6};
        new SelectionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
