package common;

import java.util.List;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Node.java
 * @Description TODO
 * @createTime 2023年06月26日 10:49:00
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
