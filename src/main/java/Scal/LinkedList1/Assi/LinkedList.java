package Scal.LinkedList1.Assi;

class Node {
    int value;
     Node next;


    public Node(int value) {
        this.value = value;
        this.next =null;
    }
}
public class LinkedList {

    private static Node head;
    private static Node tail;
    private static int size;
    private LinkedList (){
        this.size=0;
    }

    public static void insertFirst(int val){
        Node node=  new  Node(val);
        node.next = head;
        head =node;
        size+=1;
    }

    public static void insertLast(int val){
        Node node = new Node (val);
        if (head == null){
            head = node;
        }
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next=node;
        size++;
    }

    public static void insert_node(int position, int value){
        if (head == null){
            insertFirst(value);
        }
        if (position== size){
            insertLast(value);
        }
        //iterate over list for specified position
        Node temp = head;
        for (int i =0;i< position;i++){
            temp = temp.next;
        }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next= newNode;
        size++;
    }

    public static void deleteFirst(){
        if (head != null) {
            int val = head.value;
            head = head.next;
            size--;
            return ;
        }
        return;
    }

    public static void deleteLast(){
        if (size <= 1) {
            deleteFirst();
            return;
        }
        Node temp =head;
        while (temp.next.next!=null){
            temp = temp.next;
        }
        temp.next=null;
        size--;
        //return temp.value;
    }

    public static void delete_node(int position){
        if (position==0){
            deleteFirst();
            return;
        }
        if (position == size){
            deleteLast();
            return;
        }
        Node prev =head;
        for (int i = 0; i < position-1; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        size--;
    }

    public static void getMiddleElement(LinkedList  A){
        int lenofList=0;
        Node temp= head;
        while (temp!=null){
            lenofList++;
            temp= temp.next;
        }
        System.out.println("lengh:"+ lenofList);
        boolean isEven=false;
        if (lenofList%2==0){
            isEven= true;
        }

        int limit = lenofList/2;

        Node temp1= A.head;
        for (int i =0;i<limit;i++){
            temp1= head.next;
        }

        System.out.println("Prining middle element-->"+ temp1.value);
    }

    public static  void print_ll() {
        // Output each element followed by a space
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.value+"");
            temp= temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList first = new LinkedList();

//        first.insertFirst(23);
//        first.insertFirst(24);
//        first.insert_node(1,25);
        //18 -> 4 -> 34 -> 93 -> 25
//        first.insertFirst(25);
//        first.insertFirst(93);
//        first.insertFirst(34);
//        first.insertFirst(4);
//        first.insertFirst(18);
//        first.print_ll();
        first.insertFirst(36);
        first.insertFirst(95);
        getMiddleElement(first);
        //first.print_ll();
        //first.delete_node(1);
        //first.print_ll();
    }

}
