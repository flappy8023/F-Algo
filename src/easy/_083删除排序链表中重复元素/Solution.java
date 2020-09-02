package easy._083删除排序链表中重复元素;
/*输入: 1->1->2->3->3
        输出: 1->2->3*/
/*输入: 1->1->2
        输出: 1->2*/
/**
 * Definition for singly-linked list.
 * public class common.ListNode {
 *     int val;
 *     common.ListNode next;
 *     common.ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cursor = head;
        while (cursor.next!=null){
            if(cursor.val==cursor.next.val){
                cursor.next=cursor.next.next;

            }else {
            cursor=cursor.next;}

        }
        return head;

    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        Solution solution=new Solution();
        solution.deleteDuplicates(head);
    }
}