package easy._160相交链表;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class common.ListNode {
 * int val;
 * common.ListNode next;
 * common.ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    /**
     * 双重循环，效率极其恐怖~~
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode tempB = headB;
        while (null != headA) {
            tempB = headB;
            while (null != tempB) {
                if (headA == tempB) {
                    return headA;
                }
                tempB = tempB.next;
            }
            headA = headA.next;
        }
        return null;
    }

    /**
     * 哈希表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeWithHash(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (null != headB) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeWithDoublePointer(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2.next == null ? headA : p2.next;
        }
        return p1;
    }


}