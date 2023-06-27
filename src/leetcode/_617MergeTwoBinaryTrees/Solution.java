package leetcode._617MergeTwoBinaryTrees;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月27日 16:40:00
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = null;
        if (null != root1 && null != root2) {
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        } else if (null != root1) {
            root = new TreeNode(root1.val);
            root.left = mergeTrees(root1.left, null);
            root.right = mergeTrees(root1.right, null);
        } else if (null != root2) {
            root = new TreeNode(root2.val);
            root.left = mergeTrees(null, root2.left);
            root.right = mergeTrees(null, root2.right);
        }
        return root;
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * 迭代法
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTree2(TreeNode root1, TreeNode root2) {
        if (null == root1) return root2;
        if (null == root2) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            t1.val = t1.val + t2.val;
            //两个节点的左节点都不为空，加入队列
            if (null != t1.left && null != t2.left) {
                queue.offer(t1.left);
                queue.offer(t2.left);
            }
            //两个节点的右节点不为空，加入队列
            if (null != t1.right && null != t2.right) {
                queue.offer(t1.right);
                queue.offer(t2.right);
            }
            //如果t1的左节点为空，t2左节点不为空，则对t1左节点赋值
            if (null == t1.left && null != t2.left) {
                t1.left = t2.left;
            }
            //古国t1的右节点为空，t2右节点不为空，对t1右节点赋值
            if (null == t1.right && null != t2.right) {
                t1.right = t2.right;
            }
        }
        return root1;

    }

}
