package LeetCode.LinkedList;
/*
Rotate list - https://leetcode.com/problems/rotate-list/
Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateList {
    private static ListNode rotateList (ListNode head, int k ){
        //boundary condition
        if (head ==null || k ==0) return head;

        //compute length of list along with finding last node
        int count =1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            count++;
        }

        //make linked list circular
        tail.next = head;
        //Ensure rotation is within boundary
        k = k% count;

        //iterate from start to (n-k elements to skip) and we got new tail
        for(int i =0;i< count-k;i++){
            tail = tail.next;
        }

        //set new head to tail.next element since we have traversed k elements
        head = tail.next;
        tail.next = null; //reset tail.next to empty
        return head;
    }
}
