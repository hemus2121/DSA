package Scal.Stacks;

import java.util.Arrays;
import java.util.Stack;

/*
Problem Description

Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,
G[i] for an element A[i] = an element A[j] such that
j is maximum possible AND
j < i AND
A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.
 */
public class NearestSmallerElement {
    private static int [] prevSmaller(int []A){
        Stack <Integer> st = new Stack<>();
        int [] res = new int[A.length];
        for (int i=0;i<A.length;i++ ){
            //pop out all larger or equal elements since we need smaller elements
            while (!st.isEmpty() && st.peek() >=A[i]){
                st.pop();
            }
            //check if stack is empty update value to -1
            if (st.isEmpty()) res[i]=-1;
                //update to latest smallest element present on top of stack
            else res[i]=st.peek();
            //push to stack what so ever, incoming element coming in
            st.push(A[i]);
        }
        return res;

    }
    public static void main(String[] args) {
        int [] data = { 4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(prevSmaller(data)));
        int [] data1 = { 3, 2,1};
        System.out.println(Arrays.toString(prevSmaller(data1)));
    }
}
