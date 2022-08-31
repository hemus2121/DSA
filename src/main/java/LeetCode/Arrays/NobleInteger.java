package LeetCode.Arrays;
/* Noble Integer
Problem Description
Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
 */

import java.util.Arrays;
import java.util.Comparator;

public class NobleInteger {
    private static int checkNobleInteger(int [] A){
        //converting to Integer array from native type to sort them in reverse order
        Integer[] input = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort( input, Comparator.reverseOrder());

        int count =0, ans=0;
        if (A[0]==0) return 1;

        //check for rest array elements
        for (int i =1;i< A.length;i++){
            if (A[i]== A[i-1]){
                //count won't change for handling duplicates
                if (count ==A[i]){
                    ans ++;
                }
            }else{
                count = i;
                if (count == A[i]) {
                    ans ++;
                }
            }
        }
        return ans >0? 1:-1;
    }

    private static int checkNobleInteger2(int [] A){
        //converting to Integer array from native type to sort them in reverse order
        Integer [] input = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(input, Comparator.reverseOrder());

        if (input[0]==0) return 1;

        //condition check is index = Array element and previous and next element shoud not be same
        for (int i =1;i< input.length;i++){
            if (i ==input[i]  && input[i] != input[i-1]){
                return 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int [] A= { 3, 2, 1, 3};
         System.out.println(checkNobleInteger(A));
        int [] AA= {1, 1, 3, 3};
        System.out.println(checkNobleInteger(AA));
        System.out.println(checkNobleInteger2(AA));
    }
}