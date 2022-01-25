package Scal.LinkedList.Assi;

/*
Design and implement a Linked List data structure.
A node in a linked list should have the following attributes - an integer value and a pointer to the next node.
It should support the following operations:
 */

public class LinkedList1 {

    static  class node {
        int data;
        node next;
    }
    static node head = null;
    static int size_of_ll = 0;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if (position >= 1 && position <= size_of_ll + 1) {
            node temp = new node();
            temp.data = value;
            //inserting at head position
            if (position == 1) {
                temp.next = head;
                head = temp;
            } else {
                int count = 1;
                node prev = head;
                while (count < position - 1) {
                    prev = prev.next;
                    count++;
                }
                temp.next = prev.next;
                prev.next = temp;
            }
            size_of_ll++;
        }
    }
    public static void delete_node(int position) {
        // @params position, integer
        if (position >= 1 && position <= size_of_ll) {
            node temp = null;
            //deleting 1st node
            if (position == 1) {
                temp = head;
                head = head.next;
            } else {
                int count = 1;
                node prev = head;
                while (count < position - 1) {
                    prev = prev.next;
                    count++;
                }
                temp = prev.next;
                prev.next = prev.next.next;
            }
            size_of_ll--;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        node temp = head;
        int flag = 0;
        while (temp != null) {
            if (flag == 0) {
                System.out.print(temp.data);
                flag = 1;
            } else
                System.out.print(" " + temp.data);
            temp = temp.next;
        }
    }

}
