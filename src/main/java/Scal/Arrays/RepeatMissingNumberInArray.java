package Scal.Arrays;

import java.util.Arrays;

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

        //this is critical-->  n*(n+1) -sum +rep
        int miss = (int) ((1L * n * (1L * n + 1)) / 2 - sum + rep);
        return new int [] { rep, miss };
    }

    public static void main(String[] args) {
        int [] data = { 3, 1, 2, 5, 3};
        System.out.println(Arrays.toString(getMissingNumber(data)));
    }
}