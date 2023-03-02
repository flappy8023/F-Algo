package base.btree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTreeTraversal {
    //
//     *        9
//     *       / \
//     *      10  11
//     *     / \
//     *    12  13
//     *    /
//     *  14
//
    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(10);
        TreeNode n1 = new TreeNode(11);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(13);
        TreeNode b5 = new TreeNode(14);
        n2.left = n0;
        n2.right = n1;
        n0.left = n3;
        n0.right = n4;
        n3.left = b5;
        List<TreeNode> list = bft(n2);
        System.out.println("广度优先遍历:");
        for (TreeNode node : list) {
            System.out.print(node.val + " ");
        }
        System.out.println();
        System.out.println("前序深度优先遍历：");
        preDFS(n2);
        System.out.println();

        System.out.println("中序深度优先遍历:");
        inDFS(n2);
        System.out.println();

        System.out.println("后续深度优先遍历：");
        postDFS(n2);
        System.out.println();

    }

    private static List<TreeNode> bft(TreeNode treeNode) {
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(treeNode);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node);
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
        return list;
    }

    private static void preDFS(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preDFS(root.left);
        preDFS(root.right);
    }

    private static void inDFS(TreeNode root) {
        if (root == null) return;
        inDFS(root.left);
        System.out.print(root.val + " ");
        inDFS(root.right);
    }

    private static void postDFS(TreeNode root) {
        if (root == null) return;
        postDFS(root.left);
        postDFS(root.right);
        System.out.print(root.val + " ");
    }


}
