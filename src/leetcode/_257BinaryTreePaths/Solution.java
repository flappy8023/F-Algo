package leetcode._257BinaryTreePaths;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月26日 17:43:00
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, "" + root.val);
        return result;
    }

    private void dfs(TreeNode root, List<String> list, String builder) {
        if (root.left == null && root.right == null) {
            list.add(builder);
            return;
        }

        if (null != root.left)
            dfs(root.left, list, builder + "->" + root.left.val);
        if (null != root.right)
            dfs(root.right, list, builder + "->" + root.right.val);


    }
}
