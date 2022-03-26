package Scal.DynamicProg;
/*
Regular Expression Match


 */
public class RegularExpressionMatch {
    //A  - input String B-- pattern
    private static int checkExpression(String A, String B){
        int n = A.length();
        int m = B.length();
        boolean [][] dp = new boolean[n+1][m+1];
        return compute (n,m, A, B, dp) ? 1:0;
    }

    static boolean compute(int n, int m, String A, String B, boolean [][] dp){

        // BASE CASES
        // Case1 --> if length of String is empty return TRUE
        dp[0][0] =true;

        //Case2  --> Pattern is empty and String is not empty
        for (int i=1;i<=n;i++){
            dp[i][0]= false;
        }

        //Case3 --> Pattern is NOT empty and String is empty
        for (int i =1;i<= m;i++){
            if (B.charAt(i-1)=='*'){
                dp[0][i] = dp[0][i-1];
            } else
                dp[0][i] =false;
        }

        //compute
        for (int i =1;i<=n;i++){
            for (int j =1;j<=m;j++){
                if (A.charAt(i-1)== B.charAt(j-1) || B.charAt(j-1)== '?'){
                    dp[i][j] = dp [i-1][j-1];
                }else if  (B.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else dp[i][j] =false;
            }
        }
       return dp[n][m];
    }
    public static void main(String[] args) {
        System.out.println(checkExpression("aaa","a*"));
    }
}
