package base.sort;

import java.util.Arrays;

//快速排序：基于分支思想进行哨兵划分，选择一个基准值，将小于基准值的移动到左边，大于基准值的移动到右边
public class QuickSort extends Sort {
    @Override
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = partition(nums, left, right);
        quickSort(nums, left, base - 1);
        quickSort(nums, base + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        //left作为基准数
        int i = left;
        int j = right;
        //停止条件，i=j
        while (i < j) {
            //右侧指针不停左移找到第一个小于基准数的元素
            while (i < j && nums[j] >= nums[left]) j--;
            //左侧指针不停右移找到第一个大于基准数的元素
            while (i < j && nums[i] <= nums[left]) i++;
            //小的放左边，大的放右边
            swap(nums, i, j);
        }
        //两指针相撞后，交换左指针和基准数的位置，基准数将数组划分为两个子数组
        swap(nums, i, left);
        //返回基准值
        return i;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
