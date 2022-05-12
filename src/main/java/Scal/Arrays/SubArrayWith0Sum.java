package Scal.Arrays;

import java.util.HashSet;
import java.util.Set;

/*  Sub-array with 0 sum
Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1, else return 0.

 */
public class SubArrayWith0Sum {
    private static int check0SumSubArray(int []A){

        // Any subArray  problems we need to pf Array
        int [] pf = new int [A.length];
        pf[0] = A[0];
        for (int i =1;i< A.length;i++){
            pf [i] =pf[i-1]+ A[i];
        }

        // We need to check 2 conditions
        // 1. Whether PF array contains Zero  2. PF array contains repeating element
        Set<Integer> hashSet = new HashSet<>();

        for (int a : pf){
            if (a ==0) return 1;
            if (hashSet.contains(a)) return 1;
            else hashSet.add(a);
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] data = { -1, 1};
        System.out.println(check0SumSubArray(data)); //expected 0
        int [] data1 = { 1,2,3,4,5};
        System.out.println(check0SumSubArray(data1)); //expected 1
    }
}
