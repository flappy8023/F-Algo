package leetcode._107二叉树的层次遍历II;

import common.TreeNode;

import java.util.*;

/*给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

        例如：
        给定二叉树 [3,9,20,null,null,15,7],

        3
        / \
        9  20
        /  \
        15   7
        返回其自底向上的层次遍历为：

        [
        [15,7],
        [9,20],
        [3]
        ]*/
public class Solution {
    //广度优先搜索  将每层的节点依次添加 最后反转
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(null==root){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(null!=node.left){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            ans.add(list);
        }
        Collections.reverse(ans);
        return ans;
    }

    //深度优先遍历
    public List<List<Integer>> levelOrderBottom1(TreeNode root){
        if(null==root)return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root,ans,1);
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(TreeNode root, List<List<Integer>> res,int index) {
        if(root==null){
            return;
        }
        if(index>res.size()){
            res.add(new ArrayList<>());
        }
        res.get(index-1).add(root.val);
        dfs(root.left,res,index+1);
        dfs(root.right,res,index+1);
    }

}
