package leetcode._105ConstructBinaryTreeFromPreorderAndInorderTraversal;

import common.TreeNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月27日 15:43:00
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traversal(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private TreeNode traversal(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE) {
        if (preS > preE || inS > inE) return null;
        //前序序列第一个是根节点
        int rootV = preorder[preS];
        TreeNode root = new TreeNode(rootV);
        //根据根节点切割中序序列，分成左右子树的中序序列
        int cutIndex = -1;
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == rootV) {
                cutIndex = i;
                break;
            }
        }
        //构建左孩子 preE-(preS+1) = cutIndex-1-inS----->preE = cutIndex-1-inS+preS+1
        TreeNode left = traversal(preorder, preS + 1, cutIndex - inS + preS, inorder, inS, cutIndex - 1);
        //构建右孩子 preE-preS = inE-(cutIndex+1)------->preS = preE-inE+cutIndex+1
        TreeNode right = traversal(preorder, preE - inE + cutIndex + 1, preE, inorder, cutIndex + 1, inE);
        root.left = left;
        root.right = right;
        return root;
    }
}
