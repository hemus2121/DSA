package Scal.Arrays.Hashing;

import java.util.Arrays;
/* SubArray with Given Sum
Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single element "-1".
First sub-array means the sub-array for which starting index in minimum.
 */

public class SubArrayWithGivenSum {
    private static int [] getSubArrayWithGivenSum(int [] A, int B){

        long currSum = A[0];
        int startIndex = 0;

        for (int endIndex=1;endIndex<=A.length;endIndex++){

            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (currSum > B && startIndex < (endIndex - 1)) {
                currSum = currSum - A[startIndex];
                startIndex++;
            }
            // If curr_sum becomes equal to sum, then return array elements
            if (currSum == B*1L){
                return Arrays.copyOfRange(A, startIndex, endIndex);
            }
            if(endIndex < A.length){
                currSum = currSum + A[endIndex];
            }
        }
        return new int [] { -1};
    }
    public static void main(String[] args) {
        int [] data = { 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(getSubArrayWithGivenSum(data, 5))); //expected [2,3]

        int [] data1 = { 5, 10, 20, 100, 105};
        System.out.println(Arrays.toString(getSubArrayWithGivenSum(data1, 110))); //expected -1

        int [] data2 = { 1, 1000000000};
        System.out.println(Arrays.toString(getSubArrayWithGivenSum(data2, 1000000000)));
    }
}
