package Scal.Arrays.ArraysDynamicArrays;

/** Minimum Picks
 * Problem Description
 *
 * You are given an array of integers A of size N.
 * Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.
 */
public class MinimumPicks {
    private static int minPicks (int [] A){
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;
        for (int i=0;i< A.length;i++){
            if (A[i]%2==0){
                maxEven = Math.max(maxEven, A[i]);
            }else {
                minOdd = Math.min(minOdd, A[i]);
            }
        }
        return maxEven-minOdd;
    }
    public static void main(String[] args) {
         int [] data = {0, 2, 9};
        System.out.println(minPicks(data)); //expected : -7
    }
}
