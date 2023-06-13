package leetcode._018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月13日 09:21:00
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //无法组成时退出循环
            if (nums[i] > target && nums[i] > 0) {
                break;
            }
            //对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] > target && nums[i] + nums[j] > 0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    if ((long) (nums[i] + nums[j] + nums[left] + nums[right]) > target) {
                        right--;
                    } else if ((long) (nums[i] + nums[j] + nums[left] + nums[right]) < target) {
                        left++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        //对d去重
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        //对c去重
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                        result.add(list);
                    }
                }
            }

        }
        return result;
    }
}
