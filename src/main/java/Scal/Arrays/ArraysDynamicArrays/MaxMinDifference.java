package Scal.Arrays.ArraysDynamicArrays;

import java.util.Arrays;

/* Max-Min
Given an array of integers A and an integer B, find and return the difference of B'th max element and B'th min element of the array A.
 */
public class MaxMinDifference {
    private static int getMaxMin(int [] A, int B){
        Arrays.sort(A);
//        //find the bth max
//        int bthmax= 0;
//        for (int i=A.length-1;i>=A.length-B;i--){
//            bthmax = A[i];
//        }
//
//        //find the bth min
//        int bthmin= 0;
//        for (int i=0;i<B;i++){
//            bthmin = A[i];
//        }
//
//        //System.out.println("A:" + A +" bthmax: "+bthmax +  " bthmin: "+bthmin);
//        return bthmax-bthmin;
        return A[A.length-B] - A[B-1];
    }
    public static void main(String[] args) {
        int [] data ={5, 17, 100, 11};
        System.out.println( getMaxMin(data, 1)); //expected 95
    }
}
