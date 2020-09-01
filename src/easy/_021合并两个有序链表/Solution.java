package easy._021合并两个有序链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cursor = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cursor.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                cursor.next = l1;
                l1 = l1.next;
            } else if (l1.val >= l2.val) {
                cursor.next = l2;
                l2 = l2.next;

            } else {
                cursor.next = l1;
                l1 = l1.next;
            }
            cursor = cursor.next;
        }
        return result.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        Solution solution = new Solution();
        solution.mergeTwoLists(l1, l2);
    }
}