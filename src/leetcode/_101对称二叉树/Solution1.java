package leetcode._101对称二叉树;

import common.TreeNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description TODO
 * @createTime 2023年06月26日 14:31:00
 */
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root,root);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if(left.val!=right.val){
            return false;
        }
        boolean out = isSame(left.left,right.right);
        boolean in = isSame(left.right,right.left);
        return out&&in;
    }
}
