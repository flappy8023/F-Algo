package easy._021合并两个有序链表;

/**
 * Definition for singly-linked list.
 * public class common.ListNode {
 * int val;
 * common.ListNode next;
 * common.ListNode() {}
 * common.ListNode(int val) { this.val = val; }
 * common.ListNode(int val, common.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**迭代
     * @param l1
     * @param l2 master commit3
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cursor = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cursor.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                cursor.next = l1;//mastersss
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

    /**递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val>=l2.val){
            l2.next=mergeTwoLists1(l1,l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }
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