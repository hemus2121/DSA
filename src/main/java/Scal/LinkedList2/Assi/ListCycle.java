package Scal.LinkedList2.Assi;

import  Scal.LinkedList1.Assi.LinkedList1.ListNode;
/*
Problem Description

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Try solving it using constant additional space.
 */
public class ListCycle {

    public ListNode detectCycle(ListNode a) {
        //Steps 1. Detect Cycle first
        //      2.Return where cycle begins
        //boundary cases
        if (a==null || a.next == null) return null;
        ListNode slow=a,fast=a;

        //check if cycle exists in list
        boolean isCycleExists = false;
        while (fast.next!=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data==fast.data){
                isCycleExists= true;
                break;
            }
        }
        //if cycle doesn't exists
        if (!isCycleExists) return null;

        //at this point both slow and point to common node
        //take slow to start of node and move both pointers one at a time
        slow =a;
        while (slow != fast){
            slow= slow.next;
            fast= fast.next;
        }
        return slow;
    }
}
