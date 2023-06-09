package leetcode._206反转链表;

import common.ListNode;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description TODO
 * @createTime 2023年06月09日 11:06:00
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        if (head == null) {
            return head;
        }
        ListNode temp = head.next;
        while (temp != null) {
            cur.next = pre;
            pre = cur;
            cur = temp;
            temp = temp.next;
        }
        cur.next = pre;
        return cur;

    }

    public static void main(String[] args) {
    }
}
