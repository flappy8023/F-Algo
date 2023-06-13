package leetcode._454_4SumII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月12日 15:05:00
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //key 数组1和数组2中两个元素和，value：相同和的个数
        Map<Integer, Integer> sumMap = new HashMap<>();
        //遍历数组1 数组2，记录所有两个元素和的情况
        for (int i : nums1) {
            for (int i1 : nums2) {
                sumMap.put(i+i1, sumMap.getOrDefault(i+i1, 0) + 1);
            }
        }
        int count = 0;
        //遍历数组3 数组4，查找之前的和能满足相加为0的数量
        for (int i : nums3) {
            for (int i1 : nums4) {
                count += sumMap.getOrDefault(-(i+i1),0);
            }
        }
        return count;
    }

}
