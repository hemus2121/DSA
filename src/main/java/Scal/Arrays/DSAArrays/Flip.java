package Scal.Arrays.DSAArrays;

/* Flip
Problem Description

You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 */

import java.util.Arrays;

public class Flip {
    private static int [] getFlipData(String A){
        int count=0, leftIndex=0,rightIndex=0, maxSum=0;

        // init result array
        int [] result = new int [2];
        result[0]=leftIndex;
        result[1]=rightIndex;

        //iterate over array element and check for 0's and 1's
        for (int i =0;i< A.length();i ++){
            // count of 0's and 1's
            if (A.charAt(i)=='0'){
                count++;
            }else count --;

            //proceed further if number of 0's is more than max otherwise return empty array
            if ( count >maxSum){
                maxSum = count; // getting maximum count of 0's
                result[0] =leftIndex + 1;
                result[1] = rightIndex + 1;
            }

            //applying KADAN's Algo of resetting values if we get negative value in input
            if (count<0){
                leftIndex = i+1;
                rightIndex = i+1;
                count =0; //reset counters if sum is less than ZERO
            } else {
                rightIndex ++;
            }
        }
        return (maxSum ==0)? new int [0] : result;
    }
    public static void main(String[] args) {
        String s = "011";
        System.out.println(Arrays.toString(getFlipData(s)));
    }
}
