package leetcode._46Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月03日 16:35:00
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        backTracking(nums,visit);
        return result;
    }

    private void backTracking(int[] nums,boolean[] visit){
        if(nums.length==list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            backTracking(nums,visit);
            visit[i] = false;
            list.remove(list.size()-1);
        }
    }
}
