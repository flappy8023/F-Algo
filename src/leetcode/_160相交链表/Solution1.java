package leetcode._160相交链表;

import common.ListNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description TODO
 * @createTime 2023年06月09日 15:36:00
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dA = new ListNode(-1, headA);
        ListNode dB = new ListNode(-1, headB);
        int lengthA = 0, lengthB = 0;
        //分别计算a和b的长度
        while (dA != null || dB != null) {
            if (dA != null) {
                dA = dA.next;
                lengthA++;
            }
            if (dB != null) {
                dB = dB.next;
                lengthB++;
            }
        }
        ListNode dShort = lengthB > lengthA ? headA : headB;
        ListNode dLong = lengthB > lengthA ? headB : headA;
        //计算两个链表长度差值
        int diff = Math.abs(lengthA - lengthB);
        //长链表先移动到差值位置，使两个链表末尾对齐
        while (diff-- > 0) {
            dLong = dLong.next;
        }
        while (null != dShort ) {
            if (dShort == dLong) {
                return dShort;
            }
            dShort = dShort.next;
            dLong = dLong.next;
        }
        return null;
    }
}
