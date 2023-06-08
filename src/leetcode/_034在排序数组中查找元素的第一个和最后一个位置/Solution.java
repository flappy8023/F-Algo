package leetcode._034在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 二分查找
 * @createTime 2023年06月07日 11:12:00
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        //分别查找不包含target的左右边界
        int left = getLeftIndex(nums, target);
        int right = getRightIndex(nums, target);
        //1.target小于整体，或target大于整体,或者target不存在数组中
        if (left == -2 || right == -2) {
            return new int[]{-1, -1};
        }
        //2.存在target
        return new int[]{left + 1, right - 1};
    }

    private int getLeftIndex(int[] nums, int target) {
        int result = -2;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
                if (nums[mid] == target) {
                    result = end;
                }
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private int getRightIndex(int[] nums, int target) {
        int result = -2;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
                if (nums[mid] == target) {
                    result = start;
                }
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(res));
    }
}
