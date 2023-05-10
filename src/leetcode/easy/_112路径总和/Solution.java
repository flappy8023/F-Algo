package leetcode.easy._112路径总和;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

        说明: 叶子节点是指没有子节点的节点。

        示例: 
        给定如下二叉树，以及目标和 sum = 22，

        5
        / \
        4   8
        /   / \
        11  13  4
        /  \      \
        7    2      1
        返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。*/
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && null == root.right && sum - root.val == 0) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //广度优先搜索
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (null == root) return false;
        //
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        //到根节点的路径和
        Queue<Integer> valueQuue = new LinkedList<>();
        nodeQueue.offer(root);
        valueQuue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int temp = valueQuue.poll();
            if (node.left == null && node.right == null) {
                if (temp == sum) return true;
                continue;
            }
            if (null != node.left) {
                nodeQueue.offer(node.left);
                valueQuue.offer(temp + node.left.val);
            }
            if (null != node.right) {
                nodeQueue.offer(node.right);
                valueQuue.offer(node.right.val + temp);
            }
        }

        return false;
    }
}
