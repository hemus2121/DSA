package StriverSDE.Arrays;
/** Kadane’s Algorithm : Maximum Subarray Sum in an Array
 * Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum and print the subarray.
 *  TC: O(N) SC: (1)
 **/
public class MaxSubArraySumKadanAlgo {
    private static int getMaxSubArraySum(int [] data){
        // we need to maintain 2 variables running sum and Max sum so far
        int currentSum =0, maxSum = Integer.MIN_VALUE;
        for (int i =0;i< data.length;i++){
            currentSum = currentSum+data[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum <0 ){
                currentSum =0;
            }
        }
        return  maxSum;
    }
    public static void main(String[] args) {
        int [] data= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(getMaxSubArraySum(data)); //expected 6

        int [] data1 = {1};
        System.out.println(getMaxSubArraySum(data1));// expected 1
    }
}
