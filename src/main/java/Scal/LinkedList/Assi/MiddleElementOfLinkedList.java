package Scal.LinkedList.Assi;
/*
Problem Description

Given a linked list of integers. Find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
 */
public class MiddleElementOfLinkedList {

    //Method 1: iterating through complete list
    private static void printmiddleMethod1(Node A){

        //Method 1: iterating complete length of string
            int lenofList=0;
            Node temp= A;
            while (temp!=null){
                lenofList++;
                temp= temp.next;
            }
            System.out.println("lengh:"+ lenofList);
            Node temp1= A;
            for (int i =0;i<lenofList/2;i++){
                temp1= A.next;
            }
            System.out.println("Prining middle element-->"+ temp1.value);
        }

    //Method 2: iterating through complete list using 2 pointers
    private static int printmiddleMethod2(Node A){

        Node slow=A, fast=A;
        if (fast.next==null) return fast.value;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Prining middle element-->"+ slow.value);
        return slow.value;
    }

    public static void main(String[] args) {

    }
}
