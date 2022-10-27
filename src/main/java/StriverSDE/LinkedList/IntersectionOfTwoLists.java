package StriverSDE.LinkedList;
/**  Intersection of Two Linked Lists
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 * TC: O(n+m) - rating through list 1 first takes O(n), then iterating through list 2 takes O(m).
 * SC: O(N)
 */

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLists {

    // this takes extra space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //using Extra place holder to hold nodes in Set
        Set<ListNode> dataSet = new HashSet<>();
        while (headA != null){
            dataSet.add(headA);
            headA = headA.next;
        }

        //check for duplicate in set while traversing 2nd listnodes
        while (headB!= null){
            if (dataSet.contains(headB)) return headB;
            headB = headB.next;
        }

        // no intersection found
        return null;
    }

    // MOST optimal approach
    // TC: O(2*max(length of list1,length of list2))
    // SC: O(1)
    public ListNode getIntersectionNodeOpt(ListNode headA, ListNode headB){
        //No intersection if any ofthe nodes is NULL
        if (headA == null || headB ==null) return null;
        ListNode a = headA;
        ListNode b = headB;
        //check if both nodes are not equal
        while ( a != b){
            a = a==null? headB: a.next; // if null reassign to start of other list
            b = b==null? headA: b.next;
        }
        return a;
    }
}
