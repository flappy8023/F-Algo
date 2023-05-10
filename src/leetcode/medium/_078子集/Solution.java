package leetcode.medium._078子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年04月27日 15:07:00
 */

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> subList = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(subList));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            subList.add(nums[i]);
            backtracking(nums, i + 1);
            subList.remove(subList.size() - 1);
        }

    }
}