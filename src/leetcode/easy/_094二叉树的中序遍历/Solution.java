package leetcode.easy._094二叉树的中序遍历;

import java.util.*;

/*
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
 * */
public class Solution {
    /*递归1*/
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = inorderTraversal(root.left);
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    /*递归2*/
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (null == root) return;
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }

    /*迭代*/
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (null != root || !stack.isEmpty()) {
            //找到最左节点
            while (null != root) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
