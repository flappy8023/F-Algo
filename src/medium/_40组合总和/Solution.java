package medium._40组合总和;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年04月26日 15:24:00
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 难度
 * 中等
 * <p>
 * 1325
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> subList = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            //used[i-1]=true说明同一树枝candidate[i-1]使用过
            //used[i-1]=false说明同一树层candidate[i-1]使用过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            subList.add(candidates[i]);
            used[i] = true;
            sum += candidates[i];
            backtracking(candidates, target, i + 1, sum);
            sum -= candidates[i];
            used[i] = false;
            subList.remove(subList.size() - 1);
        }
    }
}