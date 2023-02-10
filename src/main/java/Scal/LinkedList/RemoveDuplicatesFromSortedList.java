package Scal.LinkedList;

/*
Problem Description

Given a sorted linked list, delete all duplicates such that each element appear only once.
 */

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode cur = A;
        while (cur !=null && cur.next!=null){
            // check if consecutive nodes values are equal
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            else cur= cur.next;
        }
        return  A;
    }
}
