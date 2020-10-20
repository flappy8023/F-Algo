package easy._101对称二叉树;
/*给定一个二叉树，检查它是否是镜像对称的。

         

        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

        1
        / \
        2   2
        / \ / \
        3  4 4  3
         

        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

        1
        / \
        2   2
        \   \
        3    3*/

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    //递归
    private boolean isMirror(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }else if(p.val!=q.val){
            return false;
        }
        return isMirror(p.left,q.right)&&isMirror(p.right,q.left);
    }

    private boolean isSymmetric1(TreeNode root){
        return check(root,root);
    }

    //迭代
    private boolean check(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            p = queue.poll();
            q= queue.poll();
            if(null==p&&q==null){
                continue;
            }
            if(null==p||null==q||p.val!=q.val){
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
