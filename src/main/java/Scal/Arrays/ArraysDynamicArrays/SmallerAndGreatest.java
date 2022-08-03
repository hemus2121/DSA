package Scal.Arrays.ArraysDynamicArrays;

/** Smaller And Greater
 * You are given an Array A of size N.
 * Find for how many elements, there is a strictly smaller element and a strictly greater element.
 */

import java.util.Arrays;

public class SmallerAndGreatest {

    private static int countSmallestGreatest(int [] A){

        int n = A.length;
        Arrays.sort(A);
        int smallest = A[0];
        int greatest = A[n-1];

        int count =0;
        //iterate array elements
        for (int i =1;i< n-1;i++){
            if (A[i]>smallest && A[i] < greatest){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int [] A = {1,2,3};
        System.out.println(countSmallestGreatest(A)); //expected 1
    }
}
