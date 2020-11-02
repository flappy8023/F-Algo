package easy._111二叉树的最小深度;

import common.TreeNode;

/*给定一个二叉树，找出其最小深度。

        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

        说明：叶子节点是指没有子节点的节点。*/
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        int leftH = minDepth(root.left);
        int rightH = minDepth(root.right);
        if(leftH==0||rightH==0){
            return Math.max(leftH,rightH)+1;
        }
        return Math.min(leftH,rightH)+1;
    }
}
