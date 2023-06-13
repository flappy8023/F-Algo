package leetcode._015_3Sum;

import java.util.*;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月12日 16:08:00
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //对数组从小到大排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //第一个数字大于0，后续的比它大，和肯定大于0
            if (nums[i] > 0) {
                continue;
            }
            //对第一个数字a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //第二个数字b下标
            int left = i + 1;
            //第三个数字c下标
            int right = nums.length - 1;
            while (right > left) {
                //加起来偏大，第三个数c减小
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    //偏小，b增大
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    //对c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    //对b去重
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.threeSum()
    }
}
