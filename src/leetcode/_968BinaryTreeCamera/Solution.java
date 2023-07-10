package leetcode._968BinaryTreeCamera;

import common.TreeNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 二叉树后续遍历 贪心
 * @createTime 2023年07月08日 14:41:00
 */
public class Solution {
    int result = 0;

    public int minCameraCover(TreeNode root) {
        //从叶子节点往上遍历，在叶子节点的父节点安装摄像头
        result = 0;
        int rootState = traversal(root);
        //如果根节点最后是无覆盖的状态，还需要在根节点安装摄像机
        if (rootState == 0) {
            result++;
        }
        return result;
    }

    /**
     * @param root
     * @return 叶子结点的状态：0：无覆盖  1：安装摄像头  2：有覆盖
     */
    private int traversal(TreeNode root) {
        //想要在叶子节点的父节点安装摄像头，空节点只能是有覆盖的状态
        if (root == null) {
            return 2;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);
        //1.左右节点都是有覆盖的状态，那父节点只能是无覆盖
        if (left == 2 && right == 2) {
            return 0;
        }
        //2.任何一个子节点是无覆盖，父节点需要安装摄像头
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }
        //3.任何一个子节点安装了摄像头，父节点的状态是有覆盖
        if (left == 1 || right == 1) {
            return 2;
        }

        return -1;
    }

}
