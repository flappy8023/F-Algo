package leetcode._1376TimeNeededToInformAllEmplyees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年05月29日 14:26:00
 */
class Solution {
    private int max = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < manager.length; i++) {
            nodes[i] = new Node();
            nodes[i].time = informTime[i];
        }
        Node root = null;
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                root = nodes[i];
            } else {
                nodes[i].parent = nodes[manager[i]];
                nodes[manager[i]].child.add(nodes[i]);
            }
        }
        dfs(root, root.time);
        return max;
    }

    private void dfs(Node root, int time) {
        if (root.child.size() == 0) {
            max = Math.max(time, max);
            return;
        }
        for (int i = 0; i < root.child.size(); i++) {
            dfs(root.child.get(i), time + root.child.get(i).time);
        }
    }

    class Node {
        Node parent;
        List<Node> child = new ArrayList<>();
        int time;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0});
        System.out.println(res);
    }
}