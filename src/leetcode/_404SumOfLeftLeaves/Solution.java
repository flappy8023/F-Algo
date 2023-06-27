package leetcode._404SumOfLeftLeaves;

import common.TreeNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月26日 22:25:00
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        //叶子节点的左叶子和为0
        if (root.left == null && root.right == null) return 0;
        //当前节点左子树的左叶子之和
        int leftSum = sumOfLeftLeaves(root.left);
        //从左叶子节点的父节点入手
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftSum= root.left.val;
        }
        //当前节点右子树的左叶子之和
        int rightSum = sumOfLeftLeaves(root.right);
        return leftSum + rightSum;
    }
}
