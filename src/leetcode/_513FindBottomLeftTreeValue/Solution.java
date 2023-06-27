package leetcode._513FindBottomLeftTreeValue;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月26日 22:49:00
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(null==root)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i==0){
                    result = node.val;
                }
                if(null!=node.left){
                    queue.offer(node.left);
                }
                if(null!=node.right){
                    queue.offer(node.right);
                }

            }
        }
        return result;
    }
}
