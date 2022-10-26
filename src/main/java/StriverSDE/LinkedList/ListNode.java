package StriverSDE.LinkedList;

//Generic definition of linked list

public class ListNode {
    int val;
    ListNode next;

    ListNode(int _val){
        this.val = _val;
    }
    ListNode(int _val, ListNode _next){
        this.val = _val;
        this.next = _next;
    }
}
