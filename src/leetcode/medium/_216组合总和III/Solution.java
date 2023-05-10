package leetcode.medium._216组合总和III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//1-9中，满足k个数字和为n的组合
//回溯算法
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int sum = 0;
    private LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);
        return result;
    }

    public void backTracking(int k, int n, int startIndex) {
        //剪枝
        if (sum > n) return;
        if (sum == n && list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - list.size()) + 1; i++) {
            list.add(i);
            sum += i;
            backTracking(k, n, i + 1);
            sum -= i;
            list.removeLast();
        }
    }
}