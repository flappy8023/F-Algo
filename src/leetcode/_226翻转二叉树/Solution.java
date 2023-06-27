package leetcode._226翻转二叉树;

import common.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (null == root)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    //

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }
}
