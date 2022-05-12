package Scal.Arrays.PFSumCarryForward;
/* Arithmetic Progression?
Problem Description
Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

 */
import java.util.Arrays;

public class ArithmeticProgression {
    private static int checkAP(int [] A){
        //sort the array to keep numbers in order
        Arrays.sort(A);
        //compute init diff
        int diff = A[1]-A[0];

        //iterate over array elements if difference is same than its AP otherwise not
        for (int i=1;i<=A.length-1;i++){
            if (A[i]-A[i-1]!=diff) return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        int [] data = { 3, 5, 1};
        System.out.println(checkAP(data)); //expected 1

        int [] data1 = { 2, 4, 1};
        System.out.println(checkAP(data1)); //expected 0
    }
}
