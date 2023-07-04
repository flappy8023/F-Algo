package leetcode._491NonDecreasingSubsequences;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 子集问题
 * @createTime 2023年07月03日 15:44:00
 */
public class Solution {
    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (list.size() > 1)
            result.add(new ArrayList<>(list));
        //元素范围-100-100,用长度为201的数组来保存本树层已经使用过的元素
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            //本层已经使用过相同元素
            if (i > 0 && used[nums[i] + 100] == 1) {
                continue;
            }
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                used[nums[i] + 100] = 1;
                backTracking(nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
