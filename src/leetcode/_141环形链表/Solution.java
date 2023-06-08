package leetcode._141环形链表;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class common.ListNode {
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
     * 通过哈希表，遍历ListNode
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**使用快慢指针，当两个指针相遇则存在环
     * @param head
     * @return
     */
    public boolean hasCycleSlowFast(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (null != fast || null != slow) {
            if (fast == slow) {
                return true;
            }
            if (null == fast.next || null == fast) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}