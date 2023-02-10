package Scal.LinkedList;

/*
 Given a singly linked list A

 A: A0 → A1 → … → An-1 → An

reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → …

You must do this in-place without altering the nodes' values.
 */
public class ReorderList {
    //Steps 1. Get middle  2. make separate list-1st and 2nd   3. reverse 2d list 4. merge 1 and 2nd

    public ListNode reorderList(ListNode A) {
        //Step 1:Get middle
        ListNode middle = getMiddle(A);
        ListNode h2 = middle.next; //created link for 2nd half List
        middle.next=null;  ////break the list into 1st and 2nd half
        reverseList(h2);
        return mergeLists(A, h2);
    }

    public ListNode mergeLists(ListNode h1, ListNode h2){
        ListNode cur= h1;
        while (h2!=null){
            // move h2 to new head and let tmp be joined to original list
            ListNode tmp=h2;
            h2= h2.next;
            tmp.next= cur.next;
            cur.next=tmp;
            cur = cur.next.next;
        }
        return h1;
    }

    public ListNode reverseList(ListNode ref){
        ListNode prev=null, cur =ref, nxt=null;
        while (cur!=null){
            nxt= cur.next;
            cur.next = prev;
            prev= cur;
            cur= nxt;
        }
        return prev;
    }
    public ListNode getMiddle(ListNode head){
        ListNode fast=head, slow=head;
        while (fast.next != null && fast.next.next != null){
            fast= fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
