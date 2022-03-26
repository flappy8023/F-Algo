package easy._206反转链表;

import common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    /*给你单链表的头节点 head ，请你反转链表，并返回反转后的链表*/

    /*使用栈*/
    public ListNode reverseList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode newHead = new ListNode(0);
        while (head != null) {
            deque.push(head);
            head = head.next;
        }
        ListNode p = newHead;
        while (!deque.isEmpty()) {
            newHead.next = deque.pop();
            newHead = newHead.next;
            newHead.next = null;
        }
        return p.next;
    }

    /*迭代*/
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (null != curr) {
            //从前往后依次交换pre和curr的指向
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /*递归   */
    public ListNode reverseList2(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        //假设k(n+1)到k(m)已经完成反转，现在需要k(n+1)的next指向k(n),即k(n).next.next = k(n)
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        solution.reverseList(node);
    }
}
