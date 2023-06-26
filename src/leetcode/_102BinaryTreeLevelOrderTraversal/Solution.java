package leetcode._102BinaryTreeLevelOrderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月26日 10:04:00
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(null!=node.left)queue.offer(node.left);
                if(null!=node.right)queue.offer(node.right);
                size--;
            }
            result.add(list);
        }
        return result;
    }
}
