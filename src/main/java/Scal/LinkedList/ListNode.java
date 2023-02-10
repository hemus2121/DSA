package Scal.LinkedList;

/* definition of generic ListNode */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){
        super();
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
