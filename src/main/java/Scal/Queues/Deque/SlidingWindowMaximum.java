package Scal.Queues.Deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.*;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    private static int [] slidingMaximum(final int[] A, int B) {

        Deque <Integer> deque = new LinkedList<>();
        List <Integer> response = new ArrayList<>();
        //lets iterate for 1st B element- First sliding window
        for (int i =0;i<B;i++){
            while (!deque.isEmpty() && deque.getLast()<A[i]){
                deque.removeLast();
            }
            deque.addLast(A[i]);
        }
        //add the first element of Deque
        response.add(deque.getFirst());

        //traverse from B To n elements- sliding window
        for (int i=B;i<A.length;i++){
            while (!deque.isEmpty() && deque.getLast()<A[i]){
                deque.removeLast();
            }
            deque.addLast(A[i]);
            // remove if outgoing element (i-B) element is same as 1st element in deque
            if (deque.getFirst()== A[i-B]){
                deque.removeFirst();
            }
            // Add to response first element of Deque
            response.add(deque.getFirst());
        }
        return  response.stream().mapToInt(val->val).toArray();

    }
    public static void main(String[] args) {
        int [] data = {1, 3, -1, -3, 5, 3, 6, 7};
        int b = 3;
       // System.out.println(Arrays.toString(slidingMaximum(data,b)));

        int [] data1= { 2, 5, -1, 7, -3, -1, -2 };
        int bb=4;
        System.out.println(Arrays.toString(slidingMaximum(data1, bb)));
    }
}
