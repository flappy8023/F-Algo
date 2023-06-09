package leetcode._707DesignLinkedList;


import common.ListNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月09日 09:55:00
 */
public class MyLinkedList {
    private int size = 0;
    private ListNode dHead = new ListNode(-1);

    public MyLinkedList() {

    }



    public int get(int index) {
        if (index >= size) return -1;
        ListNode node = dHead;
        while (index-- >= 0) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        dHead.next = new ListNode(val, dHead.next);
        size++;

    }

    public void addAtTail(int val) {
        ListNode tail = new ListNode(val, null);
        ListNode cur = dHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode pre = dHead;
        ListNode cur = dHead.next;
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index > size) {
            return;
        }
        while (index-- > 0) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = new ListNode(val, cur);
        size++;
    }

    public void deleteAtIndex(int index) {
        ListNode pre = dHead;
        ListNode cur = dHead.next;
        if (index >= size) {
            return;
        }
        while (index-- > 0) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        list.get(4);
    }
}
