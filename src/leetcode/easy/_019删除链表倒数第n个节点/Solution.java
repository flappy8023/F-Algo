package leetcode.easy._019删除链表倒数第n个节点;

import common.ListNode;

/*给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

        示例：

        给定一个链表: 1->2->3->4->5, 和 n = 2.

        当删除了倒数第二个节点后，链表变为 1->2->3->5.*/
public class Solution {
    //dev commit
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //建立哑节点，用于解决极端情况，如只有一个节点或者要删除第一个节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode cursor = head;
        //得到链表长度
        while (null != cursor) {
            length++;
            cursor = cursor.next;
        }
        cursor = dummy;//dev在rebas之前做修改，未提交
        //计算正序的元素位置
        int abN = length - n;
        for (int i = 0; i < abN; i++) {
            cursor = cursor.next;

        }
        cursor.next = cursor.next.next;
        return dummy.next;

    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //定义两个指针，第一个先后移n个位置，然后两个同时后移，当第一个指针到结尾时，第二个指向倒数第n个节点
        ListNode dummy = new ListNode(0);
        ListNode first = dummy;
        ListNode second = dummy;
        dummy.next = head;
        int i = 0;
        while (i < n) {
            i++;
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
