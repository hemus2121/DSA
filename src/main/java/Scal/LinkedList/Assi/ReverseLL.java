package Scal.LinkedList.Assi;

public class ReverseLL {
    private static Node reverse(Node A){
        //Declare 2 extra pointers
        Node prev=null, next=null;
        //handle if head is null
        if (A == null ) return null;
        //handle case where 1 element is present
        if (A==null) return A;
        //pointer for head node
        Node temp = A;
        while(temp !=null){
            next = temp;
            temp.next =prev;
            prev=temp;
            temp =next;
        }
        return prev;
    }
    public static void main(String[] args) {

    }
}
