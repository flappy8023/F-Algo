package base.search;

import common.ListNode;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 20, 23, 45, 323, 455, 634, 667, 909, 999};
        System.out.println("find 10, index = " + arrayLinearSearch(arr, 10));
        System.out.println("find 909, index = " + arrayLinearSearch(arr, 909));

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(11);
        ListNode node3 = new ListNode(12);
        ListNode node4 = new ListNode(19);
        ListNode node5 = new ListNode(110);
        ListNode node6 = new ListNode(111);
        ListNode node7 = new ListNode(121);
        ListNode node8 = new ListNode(134);
        ListNode node9 = new ListNode(156);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        System.out.println("find 11, node = " +linkedLinearSearch(node,11));
        System.out.println("find 999, node = "+linkedLinearSearch(node,999));
    }

    private static int arrayLinearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    private static ListNode linkedLinearSearch(ListNode listNode, int target) {
        while (listNode != null) {
            if (listNode.val == target) {
                return listNode;
            }
            listNode = listNode.next;
        }
        return null;
    }
}
