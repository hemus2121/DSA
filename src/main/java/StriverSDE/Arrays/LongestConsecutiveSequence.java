package StriverSDE.Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Consecutive Sequence in an Array
 * Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.
 */
public class LongestConsecutiveSequence {

    private static int getLongestConsecutiveSequence(int []A){

        Set<Integer> hashSet = new HashSet<>();
        for (int a: A){
            hashSet.add(a);
        }

        //iterate for elements
        int maxLength = Integer.MIN_VALUE;
        for (int a: A) {
            int count = 1;
            int previousElement = a - 1;
            if (!hashSet.contains(previousElement)) {
                int nextElement = a + 1;
                while (hashSet.contains(nextElement)) {
                    nextElement++;
                    count++;
                }
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
    public static void main(String[] args) {
       int [] data = {100, 4, 200, 1, 3, 2};
        System.out.println(getLongestConsecutiveSequence(data));
    }
}
