package leetcode._559MaximumDepthOfN_aryTree;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月26日 15:32:00
 */
public class Solution {
    private int maxDepth;

    public int maxDepth(Node root) {
        if(null==root)return 0;
        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(Node node, int depth) {
        if (node.children.size()==0) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        for (int i = 0; i < node.children.size(); i++) {
            dfs(node.children.get(i), depth + 1);
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node6 = new Node(6,null);
        Node node2 = new Node(2,null);
        Node node4 = new Node(4,null);
        List<Node> children = new ArrayList<>();
        children.add(node5);
        children.add(node6);
        Node node3 = new Node(3,children);
        List<Node> chidren1 = new ArrayList<>();
        chidren1.add(node2);
        chidren1.add(node4);
        chidren1.add(node3);
        Node root = new Node(1,chidren1);
        int s = new Solution().maxDepth(root);
        System.out.println(s);
    }

}
