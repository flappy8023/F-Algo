package leetcode.easy._100相同的树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

        示例 1:

        输入:       1         1
        / \       / \
        2   3     2   3

        [1,2,3],   [1,2,3]

        输出: true
        示例 2:

        输入:      1          1
        /           \
        2             2

        [1,2],     [1,null,2]

        输出: false
        示例 3:

        输入:       1         1
        / \       / \
        2   1     1   2

        [1,2,1],   [1,1,2]

        输出: false*/
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> lP = new ArrayList<>();
        List<Integer> lQ = new ArrayList<>();
        traverse(p, lP);
        traverse(q, lQ);
        return Arrays.equals(lP.toArray(), lQ.toArray());
    }

    private void traverse(TreeNode treeNode, List<Integer> list) {
        list.add(treeNode.val);
        if (treeNode == null) {
            return;
        }
        traverse(treeNode.left, list);
        traverse(treeNode.right, list);
    }

    //深度优先搜索
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
        }
    }
}
