package leetcode._515FindLargestValueInEachTreeRow;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月26日 10:56:00
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
                size--;
            }
            result.add(max);
        }
        return result;
    }
}
