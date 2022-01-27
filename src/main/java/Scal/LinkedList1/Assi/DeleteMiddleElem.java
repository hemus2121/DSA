package Scal.LinkedList1.Assi;
/*
Problem Description
Given a singly linked list, delete middle of the linked list.

For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.

For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
Return the head of the linked list after removing the middle node.
If the input linked list has 1 node, then this node should be deleted and a null node should be returned.
 */
public class DeleteMiddleElem {
    private  static Node deleteMiddleEle(Node A){
        Node slow=A, fast=A;
        //iterate till u get middle element
        while (fast !=null || fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //iterate until u get 1 node before slow
        Node temp =A;
        while (temp.next != slow){
            temp = temp.next;
        }
        // now skip middle one
        temp.next = temp.next.next;
        return A;
    }
    public static void main(String[] args) {

    }
}
