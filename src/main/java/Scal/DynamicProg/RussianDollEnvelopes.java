package Scal.DynamicProg;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  Russian Doll Envelopes
 *  Problem Description
 * Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * Find the maximum number of envelopes you can put one inside other.
 */
public class RussianDollEnvelopes {
    
    //TC: O(N^2)
    static int getCount(int [] [] A) {
        // heights denoted by 1st row
        // width denoted by 2nd row in 2D array

        //sort based on height
        Arrays.sort(A, (a, b) -> a[0] - b[0]);

        int[] dp = new int[A.length];
        int maxElement=-1;

        // apply LIS on width
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                // check both for width and height
                if (A[j][1] < A[i][1] && A[j][0] < A[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            //contribution of current element
            dp[i]++;
            maxElement = Math.max(maxElement, dp[i]);
        }
        return maxElement;
    }

    //TC: (NLOGN)
    public static int maxEnvelopes(int[][] envelopes) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        // extract the second dimension-width and run LIS on it
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i)
            secondDim[i] = envelopes[i][1];
        return lengthOfLIS(secondDim);
    }

    private static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // method returns location where element needs to be inserted
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int [][] A = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        System.out.println(getCount(A)); //expected 3
        System.out.println(maxEnvelopes(A));
    }
}
