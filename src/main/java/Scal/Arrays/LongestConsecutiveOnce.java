package Scal.Arrays;
/*
Length of longest consecutive ones

Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
 Find and return the length of the longest consecutive 1’s that can be achieved.
 */

public class LongestConsecutiveOnce {

    public static int getTotalOnce(String A) {
        int size = A.length();
        if (size <= 1)
            return A.charAt(size - 1) - '0';

        int countContinuousOne = 0, maxCountOne = 0;
        int[] prefixArr = new int[size];
        int[] suffixArr = new int[size];

// Prepare the prefix array
        prefixArr[0] = A.charAt(0) - '0';
        for (int i = 1; i < size; i++) {
            if (A.charAt(i) == '1')
                prefixArr[i] = prefixArr[i - 1] + 1;
        }

// Prepare the suffix array
        suffixArr[size - 1] = A.charAt(size - 1) - '0';
        for (int i = size - 2; i >= 0; i--) {
            if (A.charAt(i) == '1')
                suffixArr[i] = suffixArr[i + 1] + 1;
        }

// Count all the ones and get maximum length of the continuous ones
        int countAllOne = 0;
        for (int i = 0; i < size; i++) {
            if (A.charAt(i) == '1') {
                countContinuousOne++;
                countAllOne++;
            } else {
                maxCountOne = Math.max(maxCountOne, countContinuousOne);
                countContinuousOne = 0;
            }
        }
        maxCountOne = Math.max(maxCountOne, countContinuousOne);

        for (int i = 1; i < size - 1; i++) {
            if (A.charAt(i) == '0') {
                int prefixSuffixSum = prefixArr[i - 1] + suffixArr[i + 1];
    /**
        * If the count of all ones is greater than the prefix plus suffix array at
        * position i then add 1 else take the prefix plus suffix array
        */
                if (countAllOne > prefixSuffixSum) {
                    maxCountOne = Math.max(maxCountOne, prefixSuffixSum + 1);
                } else {
                    maxCountOne = Math.max(maxCountOne, prefixSuffixSum);
                }
            }
        }
        return maxCountOne;
    }

    public static void main(String[] args) {
        System.out.println(getTotalOnce("100100111101"));
    }
}
