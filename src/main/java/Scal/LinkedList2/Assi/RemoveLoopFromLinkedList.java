package Scal.LinkedList2.Assi;

import  Scal.LinkedList1.ListNode;

/*
Problem Description
Given a linked list which contains some loop.

You need to find the node, which creates a loop, and break it by making the node point to NULL.
 */
public class RemoveLoopFromLinkedList {
    //  Steps 1. Detect cycle
    // 2. get that point where cycle start
    //3.use extra pointer to get prev and disconnect it
    public ListNode solve(ListNode A) {
        ListNode slow=A, fast=A;
        boolean isCycleExists=false;

        //detect cycle
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycleExists = true;
                break;
            }
        }
        if (!isCycleExists) return  null;

        //get point where cycle start
        slow=A;
        while (slow !=fast){
            slow = slow.next;
            fast = fast.next;
        }

        //at this time both both meet at start point so either choose start or end
        removeLoop(slow);
        return A;
    }

    public void removeLoop(ListNode refNode){
        ListNode tmp = refNode;
        while (tmp.next != refNode){
            tmp = tmp.next;
        }
        tmp.next =null;
    }
}
