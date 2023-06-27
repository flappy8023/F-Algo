package leetcode._106ConstructBinaryTreeFromInorderAndPostorderTraversal;

import common.TreeNode;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月27日 14:30:00
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (0 == inorder.length || 0 == postorder.length) return null;
        //后序序列最后一个是根节点
        int rootV = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootV);
        //根据根节点切割中序序列，分成左右子树的中序序列
        int cutIndex = findCutIndex(inorder, rootV);
        //切割后左侧中序
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, cutIndex);
        //切割后右侧中序
        int[] rightInOrder = Arrays.copyOfRange(inorder, cutIndex + 1, inorder.length);
        //根据中序序列长度同样切割后续序列,需要舍弃最后一个元素，因为最后一个已经作为根节点
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, cutIndex);
        int[] rightPostOrder = Arrays.copyOfRange(postorder, cutIndex, postorder.length - 1);
        //构建左孩子
        TreeNode left = buildTree(leftInOrder, leftPostOrder);
        //构建右孩子
        TreeNode right = buildTree(rightInOrder, rightPostOrder);
        root.left = left;
        root.right = right;
        return root;

    }

    private int findCutIndex(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
