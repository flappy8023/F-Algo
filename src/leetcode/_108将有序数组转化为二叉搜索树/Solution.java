package leetcode._108将有序数组转化为二叉搜索树;

import common.TreeNode;

/*将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

        本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

        示例:

        给定有序数组: [-10,-3,0,5,9],

        一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

        0
        / \
        -3   9
        /   /
        -10  5*/
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return array2Tree(nums,0,nums.length);

    }

    //左右等分建立左右子树，中间节点作为子树根节点，递归该过程
    private TreeNode array2Tree(int[] nums, int left, int right) {
        if(left>=right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = array2Tree(nums,left,mid);
        root.right = array2Tree(nums,mid+1,right);
        return root;
    }
}
