package Scal.Arrays;

/*
 Max Sum Contiguous Subarray

Problem Description
Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.
 */

//Using KADAN'Es Algo
public class MaxSumContiguousSubArray {
    private static int computeSumUsingKadanes(int [] A){

        int ans = Integer.MIN_VALUE;
        int sum =0;

        for (int i =0;i<A.length;i++){
            sum += A[i];
            ans = Math.max(ans, sum);
            //Reset sum = 0 if anytime sum <0
            if (sum <0 ) sum =0;
        }
        return  ans;
    }
    public static void main(String[] args) {
        int [] A = {1, 2, 3, 4, -10};
        System.out.println(computeSumUsingKadanes(A));
    }
}
