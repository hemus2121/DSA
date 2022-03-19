package Scal.DynamicProg;
/*
Problem Description

You are climbing a stair case and it takes A steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Problem Constraints
1 <= A <= 36
 */
public class Stairs {
    static int dp[];
    private static int solve(int A){
        dp= new int[A+1];
        return compute(A);
    }
    private static int compute(int n){
        //base case
        if (n<=2) return n;
        if (dp[n]!=0) return dp[n];
        //compute
        dp[n]= compute(n-1) + compute(n-2);
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(solve(3));
    }
}
