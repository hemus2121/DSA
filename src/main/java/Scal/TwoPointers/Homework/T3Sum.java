package Scal.TwoPointers.Homework;

import java.util.*;
/*Problem Description

Given an array A of N integers, find three integers in A such that the sum is closest to a given number B.
Return the sum of those three integers.
Assume that there will only be one solution.
*/
public class T3Sum {
    private static int get3sum(int []A, int B){
        //sore the array to get duplicate elements together
        Arrays.sort(A);
        int minDiff = Integer.MAX_VALUE, closestSum = 0;

        //lets start from 1st element keeping it as reference
        for (int i =0;i<A.length-1;i++){
            int j = i+1;
            int k = A.length-1;
            //iterate from 2nd to last elements to ge the closest sum
            while (j<k){
                int sum = A[i]+A[j]+A[k];
                int diff = Math.abs(sum-B);
                //check the difference
                if (diff < minDiff){
                    minDiff= diff;
                    closestSum= sum;
                }
                if (diff > B) k--;
                else j++;
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {
         int [] data = {-1, 2, 1, -4};
        System.out.println(get3sum(data,1));
        
        int [] dataa={1,2,3};
        System.out.println(get3sum(dataa,6));
    }
}
