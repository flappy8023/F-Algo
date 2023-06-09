package common;

public  class ListNode {
   public int val;
   public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
    public ListNode(){

    }
    public ListNode(int x,ListNode n){
        val = x;
        next = n;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}