package Scal.LinkedList1.HomeWork;

/*
Problem Description

Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
import  Scal.LinkedList1.Assi.LinkedList1.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode cur = A;
        while (cur !=null && cur.next!=null){
            // check if consecutive nodes values are equal
            if (cur.data == cur.next.data){
                cur.next = cur.next.next;
            }
            else cur= cur.next;
        }
        return  A;
    }
}
