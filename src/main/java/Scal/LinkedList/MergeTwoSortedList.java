package Scal.LinkedList;

/*Problem Description

        Merge two sorted linked lists A and B and return it as a new list.

        The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
*/
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
      if (A ==null) return B;
      if (B==null) return A;

      ListNode mergedList = new ListNode();
      ListNode curr= mergedList;

      //start comparing values
        while (A!=null && B!=null){
            if (A.val <= B.val){
                curr.next = A;
                A=A.next;
            }else{
                curr.next=B;
                B=B.next;
            }
            curr= curr.next;
        }
        curr.next = (A==null)? B:A;
        return mergedList.next;
    }
}
