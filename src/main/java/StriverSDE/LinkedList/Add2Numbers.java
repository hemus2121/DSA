package StriverSDE.LinkedList;

/** Add two numbers represented as Linked Lists
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * TC: O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.
 * SC: O(max(m,n)). The length of the new list is at most max(m,n)+1.
 */
public class Add2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        // create a dummy node ot hold result values
        ListNode res =new ListNode();
        ListNode temp = res; // pointer to newly created node
        int carry =0;

        while (l1 !=null || l2 !=null || carry ==1){
            int sum =0;
            if  (l1 !=null){
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            // add the carry factor
            sum += carry;
            // get next carry
            carry = sum/10;

            // create new node to save the result
            ListNode node = new ListNode(sum%10);
            temp.next  = node;
            temp = temp.next;
        }
        return  res.next;
    }
}
