package leetcode.easy._119杨辉三角II;

import java.util.ArrayList;
import java.util.List;

//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        lists.add(res);
        for(int i= 1;i<rowIndex;i++){
            List<Integer> item = new ArrayList<>();
            List<Integer> preList = lists.get(i-1);
            item.add(1);
            for(int j=1;j<preList.size();j++){
                item.add(preList.get(j-1)+preList.get(j));
            }
            item.add(1);
            lists.add(item);
        }
        return lists.get(rowIndex);
    }
}
