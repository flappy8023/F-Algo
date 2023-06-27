package leetcode._112路径总和;

import common.TreeNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description TODO
 * @createTime 2023年06月26日 22:59:00
 */
public class Solution1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(null==root)return false;
        return dfs(root, root.val, targetSum);
    }


    public boolean hasPathSum1(TreeNode root,int targetSum){
        if(root==null)return false;
        if(root.left==null&&root.right==null)return targetSum==root.val;
        return hasPathSum1(root.left,targetSum-root.val)||hasPathSum1(root.right,targetSum-root.val);
    }
    private boolean dfs(TreeNode root, int sum, int target) {
        if (root.right == null && root.left == null) {
            return sum == target;
        }
        boolean left = false;
        if (null != root.left) {
            left = dfs(root.left, sum + root.left.val, target);
        }
        boolean right = false;
        if (null != root.right) {
            right = dfs(root.right, sum + root.right.val, target);

        }
        return left || right;
    }
}
