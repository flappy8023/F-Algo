package leetcode._347TopKFrequentElements;

import java.util.*;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月14日 17:20:00
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int count = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (count < k) {
                priorityQueue.add(integerIntegerEntry);
            } else {
                priorityQueue.add(integerIntegerEntry);
                priorityQueue.poll();
            }
            count++;
        }
        int[] result = new int[k];
        for (int i = priorityQueue.size()-1; i >= 0; i--) {
            result[i] = priorityQueue.poll().getKey();
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,1,1,2,2,3},2)));
    }
}
