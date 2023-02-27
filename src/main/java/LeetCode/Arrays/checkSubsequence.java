package LeetCode.Arrays;

import java.util.Arrays;
import java.util.List;

public class checkSubsequence {
   //Approach 1 - time O(n) || space (1)
    private static boolean checkSubsequence1(List<Integer> array, List<Integer> subsequence){
     //lets maintain pointer for sequence
        int sPointer = 0;
        for (int i =0;i< array.size() && sPointer < subsequence.size();i++){
             if (array.get(i) == subsequence.get(sPointer)){
                 sPointer++;
             }
        }
        return sPointer == subsequence.size();
    }

    //Approach 2 - time O(n) || space (1)
    private static boolean checkSubsequence2(List<Integer> array, List<Integer> subsequence){
        //lets maintain pointer for sequence
        int sPointer = 0;
        for (int a : array){
            if (sPointer > subsequence.size()){
                break;
            }
            if (a == subsequence.get(sPointer)){
                sPointer++;
            }
        }
        return sPointer == subsequence.size();
    }
    public static void main(String[] args) {
     System.out.println( checkSubsequence1(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(1,6,-1,10)));
     System.out.println( checkSubsequence2(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(1,6,-1,10)));
    }
}
