package leetcode._145BinaryTreePostorderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 二叉树后序遍历
 * @createTime 2023年06月21日 14:11:00
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //后续遍历与前序遍历基本一致，前序入栈顺序：中右左，后序入栈顺序：中左右，最后对访问顺序反转
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (null != node.left) {
                stack.push(node.left);
            }
            if (null != node.right) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
