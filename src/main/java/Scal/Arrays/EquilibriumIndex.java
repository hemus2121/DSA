package Scal.Arrays;
/*
Equilibrium index of an array
Problem Description

You are given an array A of integers of size N.
Your task is to find the equilibrium index of the given array
The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

NOTE:
Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.
 */
public class EquilibriumIndex {

    static int getEquilibriumIndex(int []A){
        int totalSum = 0;

        for (int a: A){
            totalSum += a;
        }

        /*
        Iterate array and for each index i, do following.
        a)  Update sum to get the right sum.
                    sum = sum - arr[i]   // sum is now right sum
        b) If leftsum is equal to sum, then return current index.
        c) update leftsum for next iteration leftsum = leftsum + arr[i]
         */

        int leftSum = 0;
        for (int i =0;i< A.length;i++){
             totalSum = totalSum - A[i]; //Reduce from totalsum current element so its right sum
             if (totalSum ==leftSum ){
                 return i;
             }
             leftSum += A[i]; //update left sum
        }
         return  -1;
    }

    public static void main(String[] args) {
        int [] data = {1,2,3,7,1,2,3};
        System.out.println(getEquilibriumIndex(data));
    }
}