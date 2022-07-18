package Scal.SubSets;

/** Sum of All Subarray
 * Problem Description
 *
 * You are given an integer array A of length N.
 * You have to find the sum of all subarray sums of A.
 * More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
 * A subarray sum denotes the sum of all the elements of that subarray.
 */
public class SumOfAllSubArrays {
    private static long computeSum(int [] A){
        long sum =0;
        int n = A.length;
        for (int i =0;i< n ;i++){
            sum += (long) A[i]* (i+1)*(n-i);
        }
        return sum;
    }
    public static void main(String[] args) {
        int [] data = {1,2, 3};
        System.out.println(computeSum(data)); //expected 20

    }
}
