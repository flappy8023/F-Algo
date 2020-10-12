package easy._035搜索插入位置;

/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

        你可以假设数组中无重复元素。

        示例 1:

        输入: [1,3,5,6], 5
        输出: 2
        示例 2:

        输入: [1,3,5,6], 2
        输出: 1
        示例 3:

        输入: [1,3,5,6], 7
        输出: 4
        示例 4:

        输入: [1,3,5,6], 0
        输出: 0*/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                pre = i;
            } else if (nums[i] == target) {
                index = i;
            }
        }
        if (index != -1) {
            return index;
        } else {
            return pre + 1;
        }
    }

    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    //二分查找，第一个num[i]>=target
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int index = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid - 1;
                index = mid;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
