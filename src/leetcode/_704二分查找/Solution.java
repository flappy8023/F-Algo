package leetcode._704二分查找;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //方法一：以[left,right]闭区间来进行二分查找
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //闭区间中left==right是成立的
        while (left <= right) {
            int mid = (left + right) / 2;
            //在右区间
            if (nums[mid] < target) {
                //一定不是mid
                left = mid + 1;
            }
            //在左区间
            else if (nums[mid] > target) {
                //一定不是mid
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //方法二：以[left，right)左开右闭区间进行二分查找
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            //在右区间，一定不是mid
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {//在左区间
                right = mid;
            } else {
                return mid;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

    }
}
