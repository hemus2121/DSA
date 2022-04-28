package LeetCode.LinkedList;
/* Linked List Cycle II -- https://leetcode.com/problems/linked-list-cycle-ii/

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.
 */
public class LinkedListCycle2 {
    private ListNode detectCycle(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        //cycle detection algo
        while (fast !=null & fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow ==fast) break; // common point both met
        }

        //Not cycle detected return null
        if (fast == null || fast.next == null) return null;

        //now to find cycle point - reset slow to head and move both pointers just 1 step
        slow = head;
        if ( slow == fast) return slow; // case where only 2 elements present and 2nd pointing to 1st

        while ( slow != fast){ // where both pointers meet is where cycle begins
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
