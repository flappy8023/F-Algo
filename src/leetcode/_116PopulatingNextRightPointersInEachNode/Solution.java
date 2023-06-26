package leetcode._116PopulatingNextRightPointersInEachNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月26日 11:10:00
 */
public class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(null==root)return root;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size =queue.size();
            Node pre = queue.peek();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(i>0){
                    pre.next = node;
                    pre = node;
                }
                if(null!=node.left)queue.offer(node.left);
                if(null!=node.right)queue.offer(node.right);
            }
        }
        return root;

    }
}
