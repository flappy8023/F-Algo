package leetcode._222CountCompleteTreeNodes;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月26日 16:00:00
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        //左边深度
        int ld = 0;
        TreeNode left = root.left;
        while (left != null) {
            ld++;
            left = left.left;
        }
        //右边深度
        int rd = 0;
        TreeNode right = root.right;
        while (right != null) {
            rd++;
            right = right.right;
        }
        if (ld == rd) {
            return (2 << ld) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        int num = new Solution().countNodes(node1);
        System.out.println(num);
    }

}
