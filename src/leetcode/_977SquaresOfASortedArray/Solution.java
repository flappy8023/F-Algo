package leetcode._977SquaresOfASortedArray;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 双指针
 * @createTime 2023年06月08日 10:57:00
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-4,-2,-1,1,2,4})));
    }
}
