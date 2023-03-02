package base.sort;

import java.util.Arrays;

//选定一个基准元素base，将base与左侧已排序元素区间的元素比较大小，插入到正确位置，需要将插入位置到base之间的元素右移一位
public class InsertionSort extends Sort {
    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];
            int j = i - 1;
            //数组右移
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }

    public static void main(String[] args) {
        InsertionSort sort1 = new InsertionSort();
        sort1.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
