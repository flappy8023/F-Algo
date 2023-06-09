package leetcode._019删除链表倒数第n个节点;

import common.ListNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description 快慢指针
 * @createTime 2023年06月09日 14:54:00
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dHead = new ListNode(-1, head);
        ListNode leftNode = dHead;
        ListNode rightNode = head;
        int num = 0;
        while (null != rightNode) {
            //先让右指针移动n部，当右指针指向最后一个节点的next，left指向倒数第n个节点的前一个结点
            if (num < n) {
                rightNode = rightNode.next;
                num++;
            } else {
                rightNode = rightNode.next;
                leftNode = leftNode.next;
            }

        }
        if (null != leftNode.next) {
            leftNode.next = leftNode.next.next;
        }
        return dHead.next;
    }
}
