package leetcode._763PartitionsLabels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description
 * @createTime 2023年07月07日 10:29:00
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        //记录每个字幕出现的最远下标
        int[] indexes = new int[26];
        for (int i = 0; i < s.length(); i++) {
            indexes[s.charAt(i) - 'a'] = i;
        }
        int start = -1;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //更新最远端
            end = Math.max(indexes[s.charAt(i) - 'a'], end);
            //当遍历到最远端，就是切割点，重新记录开始下标
            if (i == end) {
                result.add(end - start);
                start = end;
            }
        }
        return result;
    }

}
