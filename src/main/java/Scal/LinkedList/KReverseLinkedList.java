package Scal.LinkedList;

/*
Problem Description
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and
 return modified linked list.
 */
public class KReverseLinkedList {

    public LinkedList1.ListNode reverseList(LinkedList1.ListNode A, int B) {
        return reverseInRecursion(A, B);
    }

    public LinkedList1.ListNode reverseInRecursion(LinkedList1.ListNode head, int B){
        if (head == null ) return null;
        LinkedList1.ListNode prev=null, nxt=null,cur =head;
         // most of it reversing list only and reverse first k nodes
        while (cur!= null && B>0){
            nxt = cur.next;
            cur.next=prev;
            prev = cur;
            cur =nxt;
            B--;
        }
        //invoke recursively for next set of nodes
        head.next = reverseInRecursion(cur, B);
        return prev;
    }
}
