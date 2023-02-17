package StriverSDE.LinkedList;

/**  Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //creating dummy node is important
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode slow =dummyNode, fast = dummyNode;

        //iterate for first n nodes
        for  (int i =1; i<=n;i++){
            fast = fast.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
