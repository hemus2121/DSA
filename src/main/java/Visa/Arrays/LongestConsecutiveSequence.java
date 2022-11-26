package Visa.Arrays;


import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        // Hashset to hold elements
        Set<Integer> hashSet = new HashSet<>();
        for (int n : nums ){
            hashSet.add(n);
        }

        int longestCount = Integer.MIN_VALUE;
        for (int num : nums){
            int count =1;
            int prev = num-1;
            // we need to start from minimum value
            if (!hashSet.contains( prev)){
                int next = num+1;
                while (hashSet.contains(next)){
                    next++;
                    count++;
                }
                longestCount = Math.max(longestCount, count);
            }
        }
        return longestCount;
    }

    public static void main(String[] args) {
        int  [] data = { 100,4,200,1,3,2};
        System.out.println(longestConsecutive(data));
    }
}
