package leetcode._024SwapNodesInPairs;

import common.ListNode;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月09日 14:21:00
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (null == head) return null;
        ListNode dHead = new ListNode(-1, head);
        ListNode pre = dHead;
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null) {
            ListNode temp = second.next;
            first.next = temp;
            second.next = first;
            pre.next = second;
            pre = first;
            first = temp;
            if (null != first)
                second = first.next;
        }
        return dHead.next;
    }
}
