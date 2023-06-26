package leetcode._094二叉树的中序遍历;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description 二叉树中序遍历
 * @createTime 2023年06月21日 10:52:00
 */
public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.isEmpty()) {
            //先向左迭代将左子节点入栈，直到没有左子树，开始访问节点，并将右子节点入栈
            if (null != cur) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                if (null != cur.right) stack.push(cur.right);
            }
        }
        return result;
    }
}
