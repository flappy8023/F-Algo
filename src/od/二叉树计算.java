package od;

import java.util.*;

public class 二叉树计算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] midOrder = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] preOrder = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, ArrayList<Integer>> midIndexMap = new HashMap<>();
        for (int i = 0; i < midOrder.length; i++) {
            midIndexMap.putIfAbsent(midOrder[i], new ArrayList<>());
            midIndexMap.get(midOrder[i]).add(i);
        }
        Node node = buildTree(0, midOrder.length - 1, 0, preOrder.length - 1, midOrder, preOrder, midIndexMap);
        StringJoiner joiner = new StringJoiner(" ");
        midDFS(node, joiner);
        System.out.println(joiner);
    }

    private static void midDFS(Node node, StringJoiner joiner) {
        if (node == null) return;
        midDFS(node.left, joiner);
        joiner.add(node.childSum + "");
        midDFS(node.right, joiner);
    }

    static class Node {
        public Node left;
        public Node right;
        public int childSum = 0;
        public int val;

        public Node(int val) {
            this.val = val;
        }

    }

    /**
     * @param midL 子树在中序中左侧下标
     * @param midR 子树在中序中右侧下标
     * @param preL 子树在前序中左侧下标
     * @param preR 子树在谦虚中右侧下标
     * @param midOrder
     * @param preOrder
     * @param midIndexMap
     * @return
     */
    public static Node buildTree(int midL, int midR, int preL, int preR, int[] midOrder, int[] preOrder, Map<Integer, ArrayList<Integer>> midIndexMap) {
        if (preL > preR) return null;
        //前序遍历第一个是根节点
        int rootVal = preOrder[preL];
        Node root = new Node(rootVal);
        ArrayList<Integer> rootIndexes = midIndexMap.get(rootVal);
        for (Integer rootIndex : rootIndexes) {
            //中序里的根节点下标越界
            if (rootIndex < midL || rootIndex > midR) {
                continue;
            }
            //左子树节点中序里的长度
            int leftLength = rootIndex - midL;
            //判断当前节点是否是真正的根节点，
            if (!compareMidAndPre(midL, preL + 1, leftLength, midOrder, preOrder)) continue;
            int rightLength = midR - rootIndex;
            if (!compareMidAndPre(rootIndex + 1, preR - rightLength + 1, rightLength, midOrder, preOrder)) continue;
            root.left = buildTree(midL, rootIndex - 1, preL + 1, preL + leftLength, midOrder, preOrder, midIndexMap);
            root.right = buildTree(rootIndex + 1, midR, preR - rightLength + 1, preR, midOrder, preOrder, midIndexMap);
            root.childSum = (root.left==null?0:root.left.val+root.left.childSum)+(null==root.right?0:root.right.val+root.right.childSum);
            //找到正确的根节点，并且完成了递归构建
            break;
        }
        return root;

    }

    public static boolean compareMidAndPre(int midL, int preL, int legnth, int[] midOrder, int[] preOrder) {
        //分别截取中序和前序里的子树区间，排序后分别比较是否一致
        int[] arrMid = Arrays.stream(Arrays.copyOfRange(midOrder, midL, midL + legnth)).sorted().toArray();
        int[] arrPre = Arrays.stream(Arrays.copyOfRange(preOrder, preL, preL + legnth)).sorted().toArray();
        for (int i = 0; i < arrMid.length; i++) {
            if (arrMid[i] != arrPre[i]) {
                return false;
            }
        }
        return true;
    }
}
