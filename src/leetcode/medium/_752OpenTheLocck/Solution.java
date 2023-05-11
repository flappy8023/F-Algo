package leetcode.medium._752OpenTheLocck;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年05月11日 14:16:00
 */
public class Solution {
    /**
     * 定义每次拨动滚轮的8种情况
     */
    private int[][] dirs = {{1, 0, 0, 0}, {-1, 0, 0, 0}, {0, 1, 0, 0}, {0, -1, 0, 0}, {0, 0, 1, 0}, {0, 0, -1, 0}, {0, 0, 0, 1}, {0, 0, 0, -1}};
    private HashSet<String> visit = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State("0000", 0));
        HashSet<String> filter = new HashSet<>(Arrays.asList(deadends));
        if (filter.contains("0000")) return -1;
        visit.add("0000");
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (cur.value.equals(target)) return cur.step;

            for (int[] dir : dirs) {
                String next = getNext(cur.value, dir);
                if (check(next, filter)) {
                    queue.offer(new State(next, cur.step + 1));
                    visit.add(next);
                }
            }
        }
        return -1;
    }

    private boolean check(String s, HashSet<String> filter) {
        if (filter.contains(s)) return false;
        return !visit.contains(s);
    }

    private String getNext(String s, int[] op) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char value = (char) (chars[i] + op[i]);
            if (value < '0') value = '9';
            if (value > '9') value = '0';
            builder.append(value);
        }
        return builder.toString();
    }

    class State {
        String value;
        int step;

        public State(String v, int s) {
            value = v;
            step = s;
        }
    }
}
