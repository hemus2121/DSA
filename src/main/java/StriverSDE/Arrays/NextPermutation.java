package StriverSDE.Arrays;

import java.util.Arrays;

/** Next Permutation
 * Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 */

public class NextPermutation {
    public static  void nextPermutation (int [] A){
        // corner cases
        if (A== null || A.length <=1) return ;

        // get the break point where dip happens
        int breakPointIndex = A.length-2;
        while (breakPointIndex >=0 && A[breakPointIndex] >= A[breakPointIndex+1]){
            breakPointIndex--;
        }
        //now u got breakpoint - again start from last to get next higher element than value denoted by i
        if (breakPointIndex >=0){
            int index  =A.length-1;
            while ( A[index]<= A[breakPointIndex]){
                index --;
            }
            //Now swap values between breakpointindex with index value
            swapElements (A, breakPointIndex, index);
        }

        //Reverse values from breakpointIndex+1 to end of Array
        reverse(A, breakPointIndex+1, A.length-1);
    }

    static void swapElements(int [] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static void reverse(int []A, int i, int j){
        while (i< j){
            swapElements(A, i++ ,j-- );
        }
    }

    public static void main(String[] args) {
        int []  data = new int[] { 1, 3,2};  // Expected { 2, 1, 3}
        nextPermutation(data);
        System.out.println(Arrays.toString(data));
    }
}
