package Scal.Contest1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StudentFill {

    public static int solve (int [] A, int B){
        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> deque1 = new LinkedList<>();
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2= new Stack<>();
        for (int a: A){
            deque.add(a);
            deque1.add(a);
        }
        while (!deque.isEmpty()){
            if (st1.isEmpty()){
                st1.add(deque.removeFirst());
            }else if (deque.peekFirst() + st1.peek() <B){
                st1.add(deque.removeFirst());
            }
        }
        int front = st1.size();
       // System.out.println(st1.size());
        //return st1.size();

        while (!deque1.isEmpty()){
            if (st2.isEmpty()){
                st2.add(deque1.removeLast());
            }else if (deque1.peekLast() + st2.peek() <B){
                st2.add(deque1.removeLast());
            }
        }
        int back = st2.size();
       // System.out.println(st2.size());
        return  Math.max(front,back);
    }

    public static void main(String[] args) {
        int [] A = { 1, 2, 3};
        int B= 10;
        System.out.println(solve(A, B));
    }
}
