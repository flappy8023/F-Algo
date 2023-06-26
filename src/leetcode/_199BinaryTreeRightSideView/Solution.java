package leetcode._199BinaryTreeRightSideView;

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
 * @createTime 2023年06月26日 10:24:00
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (null == root) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode lastNode = null;
            while (size > 0) {
                lastNode = queue.poll();
                if (null != lastNode.left) {
                    queue.offer(lastNode.left);
                }
                if (null != lastNode.right) {
                    queue.offer(lastNode.right);
                }
                size--;
            }
            result.add(lastNode.val);
        }
        return result;
    }
}
