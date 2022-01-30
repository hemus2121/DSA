package Scal.LinkedList3.HomeWork;

import Scal.LinkedList1.Assi.LinkedList1.ListNode;

/*
Problem Description

Given a singly linked list A, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.


Problem Constraints

1 <= |A| <= 105
 */
public class PalindromeList {

    public int lPalin(ListNode A) {
        if ( A == null || A.next == null) return 1 ;

        //steps 1. find the middle element and split it accordingly and reverse 2nd half
        ListNode mid = getMiddle(A);
        ListNode splitOne = mid.next;
        mid.next=null;
        ListNode rev = reverse(splitOne);

        //2. compare 2nd half with original list and 2nd will reach end faster
        ListNode slow = A;
        ListNode fast= rev;
        while ( fast !=null){
            if (slow.data !=fast.data) {
                return 0;
            }
            slow = slow.next;
            fast= fast.next;
        }
        return 1;
    }
    ListNode reverse(ListNode node){
        ListNode prev=null, curr= node, nxt=null;
        while (curr!=null){
            nxt = curr.next;
            curr.next= prev;
            prev = curr;
            curr=nxt;
        }
        return prev;
    }

    ListNode getMiddle(ListNode node){
        ListNode slow=node, fast=node;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
