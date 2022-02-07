package Scal.Queues;

import java.util.LinkedList;
import java.util.*;
/*
Problem Description

Given an array of integers A and an integer B. We need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.

NOTE: You are required to first insert elements into an auxiliary queue then perform Reversal of first B elements.
 */
public class ReverseQElements {

    private static int [] reverseQElements(int [] A, int B){

        Queue <Integer> que = new LinkedList<>();
        for (int i =0;i<B;i++){
            que.add(A[i]);
        }

        //put elements from Q to Stack
        Stack<Integer> stack = new Stack();
        while (!que.isEmpty()){
            stack.add(que.poll());
        }

        //Add back reversed stack elements into result
        List<Integer> resList = new ArrayList<>();
        while (!stack.isEmpty()){
            resList.add(stack.pop());
        }

        //add back remaining elements
        for (int i =B;i<A.length;i++){
            resList.add(A[i]);
        }

        return resList.stream().mapToInt(val -> val).toArray();
    }
    public static void main(String[] args) {
        int [] A= { 1,2, 3, 4 ,5};
        System.out.println(Arrays.toString(reverseQElements(A, 3)));
    }
}
