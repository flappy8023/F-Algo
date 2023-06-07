package leetcode.easy._704二分查找;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description TODO
 * @createTime 2023年06月07日 09:39:00
 */
public class Solution1 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        //左闭右闭
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int start = 0, end = nums.length;
        //左闭右开
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
