package leetcode._90子集II;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年04月27日 15:24:00
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> subList = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1,2,2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //1.需要保证数组有序
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(subList));
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            //2.树层上当前元素与上个元素相等，说明是重复的，在上个元素的树枝上已被处理过
            if (i > startIndex && nums[i] == nums[i - 1]) {

            } else {
                subList.add(nums[i]);
                backtracking(nums, i + 1);
                subList.remove(subList.size() - 1);
            }
        }
    }
}