package leetcode._332ReconstructItinerary;

import java.util.*;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 重新安排行程
 * @createTime 2023年07月03日 17:46:00
 */
public class Solution {
    private Map<String, Map<String, Integer>> map = new HashMap<>();//<出发，<到达，可用次数>>

    public List<String> findItinerary(List<List<String>> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            String start = tickets.get(i).get(0);
            String arrival = tickets.get(i).get(1);
            if (null != map.get(start)) {
                Map<String, Integer> value = map.get(start);
                value.put(arrival, value.getOrDefault(arrival, 0) + 1);
                map.put(start, value);
            } else {
                Map<String, Integer> value = new TreeMap<>();
                value.put(arrival, 1);
                map.put(start, value);
            }
        }
        List<String> list = new ArrayList<>();
        list.add("JFK");
        backTracking("JFK", list, tickets.size() + 1);
        return new ArrayList<>(list);
    }

    private boolean backTracking(String start, List<String> list, int length) {
        if (list.size() == length) {
            return true;

        }

        if (map.containsKey(start)) {
            for (String end : map.get(start).keySet()) {
                int count = map.get(start).get(end);
                if (count > 0) {
                    list.add(end);
                    map.get(start).put(end, count - 1);
                    if (backTracking(end, list, length)) {
                        return true;
                    }
                    map.get(start).put(end, count);
                    list.remove(list.size() - 1);
                }
            }
        }
        return false;

    }


    public static void main(String[] args) {
        //[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("EZE");
        list.add("AXA");
        List<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("ATL");
        List<String> list2 = new ArrayList<>();
        list2.add("SFO");
        list2.add("ATL");
        List<String> list3 = new ArrayList<>();
        list3.add("ATL");
        list3.add("JFK");
        List<String> list4 = new ArrayList<>();
        list4.add("ATL");
        list4.add("SFO");
        List<List<String>> input = new ArrayList<>();
        input.add(list);
        input.add(list1);
        input.add(list2);
        input.add(list3);
        input.add(list4);
        solution.findItinerary(input);
    }
}
