package base.sort;

import java.util.Arrays;

public class BubbleSort extends Sort {
    //每次循环，从左到用比较相邻元素，将较大的放在右侧，一次循环后，最大的到最右侧，下次循环只需要比较0到n-1，以此类推
    //优化：如果一次冒泡中没有发生元素交换，说明已经是有序的，不需要继续循环，可增加标志位进行判断
    @Override
    public void sort(int[] nums) {
        boolean sorted = false;
        //外层需要循环n-1次，
        for (int i = nums.length - 1; i > 0 && !sorted; i--) {
            sorted = true;
            //内层比较i次
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sort1 = new BubbleSort();
        sort1.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
