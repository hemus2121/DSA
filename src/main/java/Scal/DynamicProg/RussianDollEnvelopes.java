package Scal.DynamicProg;

import java.util.Arrays;

public class RussianDollEnvelopes {
    static int getCount(int [] [] A) {
        // heights denoted by 1st row
        // width denoted by 2nd row in 2D array

        //sort based on height
        Arrays.sort(A, (a, b) -> a[0] - b[0]);

        int[] dp = new int[A.length];

        // apply LIS on width
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                // check for width and height
                if (A[j][1] < A[i][1] && A[j][0] < A[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            //contribution of current element
            dp[i]++;
        }

        // get max value from dp array
        int ans = 0;
        for (int d : dp) {
            ans = Math.max(ans, d);
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][] A = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        System.out.println(getCount(A));
    }
}
