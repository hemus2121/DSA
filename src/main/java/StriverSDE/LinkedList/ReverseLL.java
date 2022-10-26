package StriverSDE.LinkedList;

/** ReverseLinked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        //using extra dummy node concept
       ListNode newHead = null;
       while (head !=null){
           ListNode next = head.next;
           head.next = newHead;
           newHead = head;
           head = next;
       }
       return newHead;
    }
}
