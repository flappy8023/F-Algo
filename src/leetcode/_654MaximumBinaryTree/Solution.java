package leetcode._654MaximumBinaryTree;

import common.TreeNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月27日 16:17:00
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        //构建左子树
        root.left = buildTree(nums, start, maxIndex - 1);
        //构建右子树
        root.right = buildTree(nums, maxIndex + 1, end);
        return root;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

}
