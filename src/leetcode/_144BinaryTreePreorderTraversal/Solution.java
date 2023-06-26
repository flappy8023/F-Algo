package leetcode._144BinaryTreePreorderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月21日 09:59:00
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (null == root) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    private List<Integer> preOrderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            list.add(node1.val);
            if (null != node1.right) {
                stack.push(node1.right);
            }
            if (null != node1.left) {
                stack.push(node1.left);
            }
        }
        return list;
    }
}
