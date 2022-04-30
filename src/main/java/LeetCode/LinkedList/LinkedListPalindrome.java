package LeetCode.LinkedList;

import java.util.List;

public class LinkedListPalindrome {
    private static boolean isPalinDrome(ListNode head){

        if (head ==null || head.next==null) return true;

        //Step 1: Split linked list into the middle
        ListNode mid = getMiddle(head);
        ListNode secondHalf = mid.next;
        mid.next =null; //ensuring 1st half end is clearly marked

        //Step 2: Reverse Second Half of broken list
        ListNode reversed = reverseList(secondHalf);

        //Step 3: Compare 2 halves going 1 step wise
        ListNode slow = head; //original list
        ListNode fast = reversed; // 2nd half list

        while (fast !=null){
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    /* In place reversal of Linked List */
    private static ListNode reverseList (ListNode head){
        ListNode curr= head,prev = null, next;
        while (curr !=null){
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /* Compute middle element of the list - odd -exact middle Even - left side is higher*/
    private static ListNode getMiddle(ListNode  head){
        ListNode slow = head, fast =head;
        while (fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {

    }
}
