package Scal.Arrays.PFSumCarryForward;

/*  Sum of All Subarrays

Problem Description
You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.

 */
public class SumOfAllSubArray {
    //Using CONTRIBUTION technique
    static long sumOfAllSubArray(int [] A){
        long sum=0;
        int n = A.length;
        for (int i =0;i< n;i++){
            int left = i +1; // count of subarray where ith index element is present from 0 to ith index
            int right = n-i;  // count of subarray where ith index element is present from ith index to N-1 index (n-1-i+1)
            long total = left * right;
            sum = sum + A[i] * total;
        }
        return  sum;
    }
    public static void main(String[] args) {
        int [] data = { 1, 2, 3};
        System.out.println(sumOfAllSubArray(data));

        int [] data1 = { 2, 1, 3};
        System.out.println(sumOfAllSubArray(data1));
    }
}
