package Scal.LinkedList3;
/*
Problem Description

Given a doubly linked list of integers with one pointer of each node pointing to the next node (just like in a single link list) while the second pointer, however, can point to any node in the list and not just the previous node.
You have to create a copy of this list and return the head pointer of the duplicated list.
 */
public class CloneLinkedList {

    class ListNode {
        int val;
        ListNode next, random;
        ListNode(int x) {
            val = x;
            next = random = null;
        }
    }

    public ListNode cloneList(ListNode A) {

        //edger case
        if (A== null) return null;
        if (A.next == null) return null;

        //Step1 : make a copy of the data and insert
        ListNode curr = A;
        while (curr!=null){
            ListNode newNode = new ListNode(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        //Step 2: Update random pointers for new nodes
        curr = A;
        while (curr != null){
            if (curr.random!=null) {
                curr.next.random = curr.random.next;
            }
            curr =curr.next.next;
        }

        //Step 3: separate list
        curr = A; ListNode head2= curr.next, prev= curr.next;
        while (curr !=null){
            curr.next = curr.next.next;
            curr = curr.next;
            if (curr!=null){
                prev.next = prev.next.next;
                prev = prev.next;
            }
        }
        return head2;
    }

}
