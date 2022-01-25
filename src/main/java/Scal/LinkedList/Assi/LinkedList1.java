package Scal.LinkedList.Assi;


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

}
