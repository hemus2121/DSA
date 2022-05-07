package LeetCode.Arrays;

import java.util.Arrays;

/* Move Zero's - https://leetcode.com/problems/move-zeroes/
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note: you must do this in-place without making a copy of the array.
 */
public class MoveZeros {
    private static int [] moveZerosToEnd(int [] A){

        int zerosLastIndex =0; // index of the leftmost zero
        for (int i =0;i< A.length;i++){
            if (A[i]!= 0){
                // There are zero(s) on the left side of the current non-zero number, swap!
                if (i > zerosLastIndex){
                    A[zerosLastIndex ] = A[i]; // swap it with lastZerosIndex
                    A[i] =0; // set the swapped element to zero
                }
                zerosLastIndex++;
            }
        }
        return  A;
    }

    //BEST solution
    private static int [] moveZerosToEnd2(int [] A){
        int left=0;
        //blindly copy elements if they are non zero to start location
        for (int a : A){
            if (a !=0){
                A[left++] =a;
            }
        }

        // if any elements left set to ZERO
        while (left < A.length){
            A[left++] =0;
        }
        return A;
    }

    public static void main(String[] args) {
        int [] data =  { 0,1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZerosToEnd(data)));
        System.out.println(Arrays.toString(moveZerosToEnd2(data)));
    }
}
