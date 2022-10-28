package StriverSDE.LinkedList;

/** Detect cycle in Linked List
 * Problem Statement: Given head, the head of a linked list, determine if the linked list has a cycle in it. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 *  TC: O(N)
 *  SC: (1)
 */
public class DetectCycle {

    public boolean hasCycle(ListNode head) {
        if (head ==null) return false;
        // using 2 pointers
        ListNode slow = head ;
        ListNode fast = head;
        while (fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
