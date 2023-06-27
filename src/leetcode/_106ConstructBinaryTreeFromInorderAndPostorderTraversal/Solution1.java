package leetcode._106ConstructBinaryTreeFromInorderAndPostorderTraversal;

import common.TreeNode;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description TODO
 * @createTime 2023年06月27日 14:57:00
 */
public class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traversal(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    private TreeNode traversal(int[] inorder, int inS, int inE, int[] postorder, int postS, int postE) {
        if (inS > inE || postS > postE) return null;
        //后序序列最后一个是根节点
        int rootV = postorder[postE];
        TreeNode root = new TreeNode(rootV);
        //根据根节点切割中序序列，分成左右子树的中序序列
        int cutIndex = -1;
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == rootV) {
                cutIndex = i;
                break;
            }
        }
        //构建左孩子
        TreeNode left = traversal(inorder, inS, cutIndex - 1, postorder, postS, postS + cutIndex - 1 - inS);
        //构建右孩子   postE-1 = postS+(inE-cutIndex-1)--->postS = postE-inE+cutIndex
        TreeNode right = traversal(inorder, cutIndex + 1, inE, postorder, postE - inE + cutIndex, postE - 1);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

}
