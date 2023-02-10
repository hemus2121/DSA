package Scal.LinkedList;

/*
Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass. 
 */
public class ReverseLinkList2 {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode temp = A;
        ListNode first=null,  from=null, to=null, last=null;
        int count =0;
        //Iterate to get point to B to C
        while (temp !=null){
            count++;
            if (count < B){
                first = temp;
            }
            if (count==B){
                from = temp;
            }
            if (count ==C){
                to = temp;
                last = temp.next;
                break;
            }
            temp = temp.next;
        }
        //make to nullify to.next to consider that as standalone list
        to.next = null;
        reverseList(from);

        //attache last set of nodes after reversal
        from.next = last;

        if (first !=null) first.next=to;
        else A =to;

        return A;
    }

    private static void reverseList(ListNode head){
        ListNode prev=null, nxt=null, cur = head;
        while (cur !=null){
            nxt =cur.next;
            cur.next= prev;
            prev = cur;
            cur = nxt;
        }
    }
}
