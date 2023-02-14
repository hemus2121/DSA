package Scal.LinkedList;

/**
Problem Description

Given a linked list A, remove the B-th node from the end of list and return its head.
For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.

NOTE: If B is greater than the size of the list, remove the first node of the list.
NOTE: Try doing it using constant additional space.
 */

public class RemoveNthNodeFromEnd {
    private static ListNode removeNthFromEnd(ListNode A, int B){
        if (B==1&& A.next==null) return null;
        if (A== null ) return null;
        //count number of nodes
        int count =0;
        ListNode tmp = A;
        while (tmp != null){
            count++;
            tmp = tmp.next;
        }
        // check if mentioned count is > actual count. we need to remove first node
        if (B> count) return A.next;

        tmp =A; ListNode cur =A;
        //init and move new pointer to B distance apart
        for (int i =1;i<=B;i++){
            cur = cur.next;
        }

        // move to last element
        while (cur.next!=null){
            cur=cur.next;
            tmp = tmp.next;
        }

        //now revise tmp connection
        tmp.next = tmp.next.next;
        return A;
    }
}
