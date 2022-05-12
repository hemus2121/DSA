package Scal.Arrays.PFSumCarryForward;
/*
Problem Description
 You are given an array of N integers, A1, A2, …. AN.
 Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

 */
public class MinimumAbsoluteDiff {
    private static int getMaximumDifference(int []A){

        int min_sub =A[0], max_sub = A[0];

        //case of subtraction -i
        for (int i =1;i < A.length;i++){
            min_sub = Math.min(min_sub, A[i]-i);
            max_sub = Math.max(max_sub, A[i]-i);
        }
        //probable answer
        int diff1 = max_sub - min_sub;

        // case of addition +i
        int min_add = A[0], max_add= A[0];

        for (int i =1;i < A.length;i++){
            min_add = Math.min( min_add, A[i]+i);
            max_add = Math.max(max_add, A[i]+i);
        }
        return  Math.max(diff1, max_add- min_add);
    }

    public static void main(String[] args) {
        int [] A = { 1, 3, -1};
        System.out.println(getMaximumDifference(A));
    }
}
