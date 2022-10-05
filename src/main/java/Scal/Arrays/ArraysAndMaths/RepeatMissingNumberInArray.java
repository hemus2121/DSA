package Scal.Arrays.ArraysAndMaths;

import java.util.Arrays;

/* Repeat and Missing Number Array
You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.
 */
public class RepeatMissingNumberInArray {

    private static int [] getMissingNumber (int [] A){

        //sort input array so that elements are in order and easy to find missing repeating element
        Arrays.sort(A);

        int n = A.length;
        int rep = -1;
        long sum = A[0];

        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1]) {
                rep = A[i];
            }
            sum += A[i];
        }

        //this is CRITICAL-->  n*(n+1) -sum +rep
        int miss = (int) (( n * (1L * n + 1)) / 2 - sum + rep);
        return new int [] { rep, miss };
    }

    public static void main(String[] args) {
        int [] data = { 3, 1, 2, 5, 3};
        System.out.println(Arrays.toString(getMissingNumber(data)));
    }
}
