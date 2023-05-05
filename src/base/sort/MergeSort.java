package base.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 「递归划分」 从顶至底递归地 将数组从中点切为两个子数组，直至长度为 1 ；
 * <p>
 * 计算数组中点 mid ，递归划分左子数组（区间 [left, mid] ）和右子数组（区间 [mid + 1, right] ）；
 * 递归执行 1. 步骤，直至子数组区间长度为 1 时，终止递归划分；
 * 「回溯合并」 从底至顶地将左子数组和右子数组合并为一个 有序数组 ；
 * <p>
 * 需要注意，由于从长度为 1 的子数组开始合并，所以 每个子数组都是有序的。因此，合并任务本质是要 将两个有序子数组合并为一个有序数组。
 */
public class MergeSort extends Sort {


    @Override
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        //当数组长度为1时停止递归
        if (left >= right) return;
        //根据中点划分
        int mid = left + (right - left) / 2;
        //递归左子数组
        mergeSort(nums, left, mid);
        //递归右子数组
        mergeSort(nums, mid + 1, right);
        //合并阶段
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        //辅助数组
        int[] temp = Arrays.copyOfRange(nums, left, right + 1);
        //左子数组在辅助数组中的起始索引和结束索引
        int leftStart = left - left, leftEnd = mid - left;
        //右子数组在辅助数组中的其实索引和结束索引
        int rightStart = mid - left + 1, rightEnd = right - left;
        //i，j分别指向左右子数组的首元素
        int i = leftStart, j = rightStart;
        //通过覆盖原数组来合并左子数组和右子数组
        for (int k = left; k <= right; k++) {
            //左子数组已经完成合并，则选取右子数组元素，j++
            if (i > leftEnd) {
                nums[k] = temp[j++];
            }
            //如果右子数组已完成合并或者左子数组元素小于右子数组元素，那选取左子数组元素，i++
            else if (j > rightEnd || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            }
            //如果左右子数组都未全部合并完，并且左子数组元素大于右子数组元素，那选取右子数组元素，j++
            else {
                nums[k] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
