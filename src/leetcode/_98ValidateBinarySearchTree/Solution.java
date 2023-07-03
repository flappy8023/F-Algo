package leetcode._98ValidateBinarySearchTree;

import common.TreeNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月27日 17:54:00
 */
public class Solution {
    private TreeNode preNode;

    /**
     * 中序遍历，形成的访问顺序应该是升序
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (null == root) return true;
        boolean left = isValidBST(root.left);
        if (null == preNode || root.val > preNode.val) preNode = root;
        else return false;
        boolean right = isValidBST(root.right);
        return left && right;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        node.left = node1;
        solution.isValidBST(node);
    }
}
