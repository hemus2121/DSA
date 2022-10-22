package Scal.Stacks;

import java.util.Stack;

/**
Problem Description

Given an array of integers A .

A represents a histogram i.e A[i] denotes height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.

 using 3 iteration
 */
public class LargestRectangleInHistogram {
    // BASED on NearestSmaller Element concept
    private static int getLargestRectangle(int []A){
        int [] nearSmallestOnLeft = nearSmallestOnLeft(A);
        int [] nearSmallestOnRight = nearSmallestOnRight(A);

        // get the maximum rectangle of all elements
        long area=0;
        for (int i=0;i<A.length;i++){
            int l = nearSmallestOnLeft[i];
            int r = nearSmallestOnRight[i];
            area = Math.max(area, (r-l-1)*A[i]);
        }
        return (int)area;
    }

    //build near smallest elements response from left side
    private static int[] nearSmallestOnLeft(int[] A) {
        Stack<Integer> st = new Stack<>();
        int [] leftSmaller = new int[A.length];
        // start from left side
        for (int i =0;i <A.length;i++ ){
            //popout until u have larger elements on top of stack because we need smaller elements
            while (!st.isEmpty() && A[st.peek()]>= A[i]){
                st.pop();
            }
            if (st.isEmpty()) leftSmaller[i]=-1;
            else leftSmaller[i]=st.peek();
            st.push(i);
        }
        return leftSmaller;
    }


    // build near smallest elements response from right side
    //condition check is SAME in while loop but iterate from A.length-1
    private static int[] nearSmallestOnRight(int[] A) {
        Stack<Integer> st = new Stack<>();
        int [] res = new int[A.length];
        //start from right side
        for (int i =A.length-1;i >-1;i-- ){
            //popout until u have larger elements on top of stack
            while (!st.isEmpty() && A[st.peek()]>= A[i]){
                st.pop();
            }
            if (st.isEmpty()) res[i]=-1;
            else res[i]=st.peek();
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] data = {2, 1, 5, 6, 2, 3};
        System.out.println(getLargestRectangle(data));
    }
}
