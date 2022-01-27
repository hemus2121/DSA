package Scal.LinkedList.Homework;

import Scal.LinkedList.Assi.LinkedList1.ListNode;

/*
Problem Description

Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class RemoveDuplicatesSortedList {

    private static ListNode removeDuplicates(ListNode A){

        //init tmp Node- using single pointer
        ListNode tmp = A;
        while (tmp != null && tmp.next!= null){
            if (tmp.data == tmp.next.data){
                tmp.next = tmp.next.next;
            }
            else tmp= tmp.next ;
        }
        return A;
    }
    public static void main(String[] args) {

    }
}
