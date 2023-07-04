package leetcode._47PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月03日 16:51:00
 */
public class Solution {
    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums, new boolean[nums.length]);
        return result;
    }

    private void backTracking(int[] nums, boolean[] visit) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //对同树层已经使用过相同元素的情况去重
            if (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]) {
                continue;
            }
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            backTracking(nums, visit);
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permuteUnique(new int[]{1, 1, 2});
    }
}
