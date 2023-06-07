package leetcode.easy._035搜索插入位置;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description TODO
 * @createTime 2023年06月07日 10:16:00
 */
public class Solution1 {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return nums[mid] > target ? mid : mid + 1;
    }
}
