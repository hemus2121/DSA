package Scal.LinkedList;

/*
Problem Description

Given a linked list A, swap every two adjacent nodes and return its head.

NOTE: Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode A) {
        if (A==null ) return null;
        if (A.next == null) return A;

        //using dummy node approach
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = A;

        while (curr != null && curr.next !=null){
            // point new node to curr.next
            prev.next = curr.next;
            //connect current next to next joining node ie.3rd node
            curr.next= curr.next.next;
            // break the connection between 2 and 3rd node
            prev.next.next= curr;
            //move the current to next current
            curr= curr.next;
            //move the previous to lattest node in chain
            prev = prev.next.next;
        }
        return dummy.next;
    }
}
