package Scal.DynamicProg.TwoDArray;

/* 0/1 kanpsack

Problem Description
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
Also given an integer C which represents knapsack capacity.
Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class ZeroOneKnapsack {

    // Sol1 - Bottom UP approach - Iterative approach
    private static  int knapsackIteration(int [] values, int [] wt ,int capacity){

        int [] [] dp = new int [ wt.length+1][capacity+1];

        //setting 1st row values as zero
        for (int i =0;i<=capacity;i++){
            dp[0][i]=0;
        }
        //setting 1st column values as zero
        for (int i=0;i<= wt.length;i++){
            dp [0][i] =0;
        }

        for (int i=1;i<= wt.length;i++){
            for (int j=1;j<=capacity;j++){

                //check for knapsack capacity if that can handle current weight
                if (j >= wt[i-1]){
                    //select maximum ( NOT selecting OR selecting and adding value for selected item)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]]+ values[i-1]);
                } else {
                    // skip the current element
                    dp [i][j] = dp[i-1][j];
                }
            }
        }
        return  dp[wt.length][capacity];
    }


     //Sol2 - Using TopDown approach - Recursion
    static int [] [] dp;
    private static  int knapsackRecursion(int []A, int[] B, int C ){
        dp = new int[A.length+1][C+1];
        return computeRecursion(A.length, C, A, B);
    }

    static int computeRecursion(int noOfItems , int weight, int [] val,int [] wt) {
        //BAse case - ran out of length of knapsack capacity or
        if (noOfItems == 0 || weight == 0) return 0;

        //if found in cache
        if (dp[noOfItems][weight] != 0) return dp[noOfItems][weight];

        //computation
        if (weight >= wt[noOfItems - 1]) {
            dp[noOfItems][weight] = Math.max(computeRecursion(noOfItems - 1, weight, val, wt),
                                             computeRecursion(noOfItems - 1, weight - wt[noOfItems - 1], val, wt) + val[noOfItems - 1]);
        } else {
            dp[noOfItems][weight] = computeRecursion(noOfItems - 1, weight, val, wt);
        }
        return dp[noOfItems][weight];
    }

    public static void main(String[] args) {
        int [] A =  {60, 100, 120};
        int [] B =  {10, 20, 30};
        int C = 50;
        System.out.println(knapsackIteration(A, B,C));
        System.out.println(knapsackRecursion(A,B,C));
    }
}
