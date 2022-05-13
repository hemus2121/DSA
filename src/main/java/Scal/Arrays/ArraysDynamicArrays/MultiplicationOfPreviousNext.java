package Scal.Arrays.ArraysDynamicArrays;

import java.util.Arrays;

/*
Given an array of integers A, update every element with multiplication of previous and next elements with following exceptions.
a) First element is replaced by multiplication of first and second.
b) Last element is replaced by multiplication of last and second last.
 */
public class MultiplicationOfPreviousNext {
    public static int[] computeMulitplicationOfPreviousNext(int[] A) {

        if (A.length==1) return A;
        int [] resultArray = new int[A.length];
        resultArray[0] = A[0]*A[1];
        resultArray[A.length-1] = A[A.length-1] *A [A.length-2];

        for (int i =1;i< A.length-1;i++){
            resultArray[i] = A[i-1] *A[i+1];
        }
        return resultArray;
    }
    public static void main(String[] args) {
        int [] data = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(computeMulitplicationOfPreviousNext(data))); //2, 3, 8, 15, 20

    }
}
