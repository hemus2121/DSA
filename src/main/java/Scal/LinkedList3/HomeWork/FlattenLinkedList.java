package Scal.LinkedList3.HomeWork;


/*
Problem Description

Given a linked list where every node represents a linked list and contains two pointers of its type:

    Pointer to next node in the main list (right pointer)
    Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.

You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.'

hint : https://www.geeksforgeeks.org/flattening-a-linked-list/
 */
public class FlattenLinkedList {

    class ListNode {
        int val;
        ListNode right, down;

        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

        ListNode flatten(ListNode root) {
            if (root == null || root.right == null) return root;
            root.right = flatten(root.right);
            return mergeTwoList(root, root.right);
        }

        ListNode mergeTwoList(ListNode a, ListNode b) {
            if (a == null) return b;
            if (b == null) return a;

            ListNode ans;
            if (a.val < b.val) {
                ans = a;
                ans.down = mergeTwoList(a.down, b);
            } else {
                ans = b;
                ans.down = mergeTwoList(a, b.down);
            }
            ans.right = null;
            return ans;
        }
    }
