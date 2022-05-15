package Scal.Arrays.Hashing;

import java.util.HashSet;
import java.util.Set;

/* Longest Consecutive Sequence
Problem Description
Given an unsorted integer array A of size N.
Find the length of the longest set of consecutive elements from array A.
 */
public class LongestConsecutiveSequence {
    private static int getLongestConsecutiveSequence(int []A){
        //Set to store unique elements
        Set<Integer> dataSet = new HashSet<>();
        for (int a : A){
            dataSet.add(a);
        }

        int maxLength= Integer.MIN_VALUE;
        for (int data:dataSet){
            int count =1;
            int previousElement = data-1;
            // if previous element not found current element can be starting element
            if (!dataSet.contains(previousElement)){
                int nextElement = data+1;
                while (dataSet.contains(nextElement)){
                    nextElement++;
                    count++;
                }
            }
            maxLength = Math.max(maxLength, count); // max length of consecutive elements till now
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int [] data = {100, 4, 200, 1, 3, 2};
        System.out.println(getLongestConsecutiveSequence(data));
    }
}
