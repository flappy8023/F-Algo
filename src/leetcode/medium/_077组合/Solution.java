package leetcode.medium._077组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合
 * <p>
 * 回溯算法
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return result;
    }

    public void backTracking(int n, int k, int startIndex) {
        if (list.size() == k) {
            //需要使用新的列表，否则后续的操作会影响已经加入结果列表中的数据
            result.add(new ArrayList<>(list));
            return;
        }
        //可以进行剪枝优化，每一层循环中剩余可组合的数字（n-i+1）不足指定个数k中缺少的元素个数(k-list.size)时不需要在进行遍历,
        //即n-i+1>=k-list.size，也即i<=n-(k-list.size)+1
//        for (int i = startIndex; i <= n; i++) {
//            list.add(i);
//            backTracking(n, k, i + 1);
//            list.removeLast();
//        }
        for (int i = startIndex; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backTracking(n, k, i + 1);
            list.removeLast();
        }
    }
}
