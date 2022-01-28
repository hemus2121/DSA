package Scal.LinkedList1.Assi;

import  Scal.LinkedList1.Assi.LinkedList1.ListNode;

/*
Problem Description
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and
 return modified linked list.
 */
public class KReverseLinkedList {

    public ListNode reverseList(ListNode A, int B) {
        return reverseInRecursion(A, B);
    }

    public ListNode reverseInRecursion(ListNode head, int B){
        if (head == null ) return null;
        ListNode prev=null, nxt=null,cur =head;
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
