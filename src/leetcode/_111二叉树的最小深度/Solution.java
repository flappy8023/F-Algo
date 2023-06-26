package leetcode._111二叉树的最小深度;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*给定一个二叉树，找出其最小深度。

        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

        说明：叶子节点是指没有子节点的节点。*/
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftH = minDepth(root.left);
        int rightH = minDepth(root.right);
        if (leftH == 0 || rightH == 0) {
            return Math.max(leftH, rightH) + 1;
        }
        return Math.min(leftH, rightH) + 1;
    }

    public int minDepth1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        int result = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
                size--;
                if (null == node.right && node.left == null) {
                    return result + 1;
                }
            }
            result++;
        }
        return result;
    }
}
