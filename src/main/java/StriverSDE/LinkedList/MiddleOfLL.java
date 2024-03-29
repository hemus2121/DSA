package StriverSDE.LinkedList;

/** Find middle element in a Linked List
 * Problem Statement: Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 */
public class MiddleOfLL {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast =head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
