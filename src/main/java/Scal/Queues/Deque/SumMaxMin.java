package Scal.Queues.Deque;

import java.util.*;
/*
Problem Description

Given an array A of both positive and negative integers.
Your task is to compute sum of minimum and maximum elements of all sub-array of size B.
NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
 */
public class SumMaxMin {
    public static int solve(int[] A, int B) {
        // we need to have 2 Queues to get max and min
        int [] max = computeMax(A, B);
        int [] min = computeMin(A, B);

        long sum = 0;
        int mod = (int)Math.pow(10,9)+7;

        for (int i =0;i<max.length;i++){
            sum = (max[i]+min[i])%mod + sum %mod;
        }
        return (int)(sum%mod);
    }

    // B denotes sliding window - compute max
    public static int [] computeMax(int [] A, int B){
        Deque<Integer> deque = new LinkedList();
        //SIZE of result array is n-B+1
        int [] res= new int [A.length-B+1];
        //lets compute for 1st window
        for (int i =0;i<B;i++){
            while (!deque.isEmpty() && deque.getLast()<A[i]){
                deque.removeLast();
            }
            deque.addLast(A[i]);
        }
        res[0] = deque.getFirst();

        //lets iterate next slidign window
        int ii =1;
        for (int i=B; i <A.length;i++){

            while (!deque.isEmpty() && deque.getLast()<A[i]){
                deque.removeLast();
            }
            deque.addLast(A[i]);

            //condition checke out going element
            if (deque.getFirst()== A[i-B]){
                deque.removeFirst();
            }
            res[ii++]=deque.getFirst();
        }
        return res;
    }

    // compute min
    public static  int [] computeMin(int [] A, int B){
        Deque <Integer> deque = new LinkedList();
        //SIZE of result array n-B+1
        int [] res= new int [A.length-B+1];
        //lets compute for 1st window
        for (int i =0;i<B;i++){
            while (!deque.isEmpty() && deque.getLast()>A[i]){
                deque.removeLast();
            }
            deque.addLast(A[i]);
        }

        res[0] = deque.getFirst();
        //lets iterate next slidign window
        int ii =1;
        for (int i=B; i <A.length;i++){
            while (!deque.isEmpty() && deque.getLast()>A[i]){
                deque.removeLast();
            }
            deque.addLast(A[i]);

            //condition checke out going element
            if (deque.getFirst()== A[i-B]){
                deque.removeFirst();
            }
            res[ii++]=deque.getFirst();
        }
        return res;
    }
    public static void main(String[] args) {
        int [] A = {2, 5, -1, 7, -3, -1, -2 };
        System.out.println(solve(A, 4));
    }
}
