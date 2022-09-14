package Scal.TwoPointers.Homework;

import java.util.Arrays;

/**
Problem Description

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.
// refer- https://www.youtube.com/watch?v=uvB-Ns_TVis&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=109

 */
public class SortByColor {

    private static  int [] sortColors(int[] A){
        // we need  3pointers 1 - at start , 2nd at end and 3rd is current running point
        // left points to 0's latest posn
        // right points to 2's latest posn
        // current points to running posn

        int start =0, end= A.length-1, cur=0;

        // 3 cases -
        // 1. if current = ZERO swap left <-> current and increment both
        // 2. If current=1 increment curr
        // 3. If current=2 swap with right and decrement right pointer t
        while (cur <= end){
            if (A[cur]==0){
                swap(A, cur, start);
                cur++;
                start++;
            } else if (A[cur]==2){
                swap (A, cur, end);
                end--;
            }else cur++;
        }
        return A;
    }

    private static void swap (int []A, int p1, int p2){
        int temp = A[p1];
        A[p1]= A[p2];
        A[p2]= temp;
    }
    
    public static void main(String[] args) {
        int [] data = { 0,1,2,0,1,2};
        System.out.println(Arrays.toString(sortColors(data)));
    }
}
