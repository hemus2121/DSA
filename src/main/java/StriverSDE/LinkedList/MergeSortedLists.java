package StriverSDE.LinkedList;


/** Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode (-1);
        ListNode temp= newList;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) temp.next = list1;
        if (list2 !=null) temp.next = list2;
        return  newList.next;
    }
}
