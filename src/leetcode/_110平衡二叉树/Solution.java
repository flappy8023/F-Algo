package leetcode._110平衡二叉树;
/*
给定一个二叉树，判断它是否是高度平衡的二叉树。

        本题中，一棵高度平衡二叉树定义为：

        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
*/


import common.TreeNode;

public class Solution {
    //自顶向下递归
    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    //自底向上的递归
    private int height1(TreeNode root){
        if(root==null){
            return 0;
        }
        int lHeight = height1(root.left);
        int rHeight = height1(root.right);
        if(lHeight==-1||rHeight==-1||Math.abs(lHeight-rHeight)>1){
            return -1;
        }else {
            return Math.max(lHeight,rHeight)+1;
        }
    }
}
