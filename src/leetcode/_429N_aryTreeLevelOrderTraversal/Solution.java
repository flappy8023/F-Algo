package leetcode._429N_aryTreeLevelOrderTraversal;

import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月26日 10:48:00
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                Node node = queue.poll();
                list.add(node.val);
                if (null != node.children) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
                size--;
            }
            result.add(list);
        }
        return result;
    }
}
