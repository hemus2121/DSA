package Visa.DynamicProgramming;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        return iterativeSoln(n);
    }

    //using iterative method
    private  static int iterativeSoln(int n ){
        int [] dp= new int [n+1];
        if (n ==1) return 1;
        //base cases
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        //compute for n stairs from base case
        for (int i = 3;i<=n;i++){
            dp[n] = dp[i-1]+ dp[i-2];
        }
        return  dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
