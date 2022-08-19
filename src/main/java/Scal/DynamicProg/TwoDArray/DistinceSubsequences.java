package Scal.DynamicProg.TwoDArray;

//Reference - https://takeuforward.org/data-structure/distinct-subsequences-dp-32/

public class DistinceSubsequences {
    static int prime =(int)(Math.pow(10,9)+7);

    static int subsequenceCounting(String s1, String s2, int n, int m) {
        // Write your code here.

        int dp[][]=new int[n+1][m+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<m+1;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){

                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%prime;
                else
                    dp[i][j] = dp[i-1][j];
            }
        }


        return dp[n][m];
    }

    public static void main(String args[]) {

        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("The Count of Distinct Subsequences is "+
                subsequenceCounting(s1,s2,s1.length(),s2.length()));
    }
}
