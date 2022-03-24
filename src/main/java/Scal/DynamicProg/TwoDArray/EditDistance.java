package Scal.DynamicProg.TwoDArray;


//https://leetcode.com/problems/edit-distance/discuss/1810472/Java-solution-using-tabulation-and-memoization
//https://leetcode.com/problems/edit-distance/discuss/1776443/Java-oror-3-Solution-oror-Recursive-oror-Memoization-oror-Top-Down-(Iterative)

public class EditDistance {

    static int [] [] dp  = null;
    private static int computeEditDistance(String A, String B){
        int m = A.length();
        int n = B.length();
        dp = new int[m+1][n+1];
        //return  computeRecursively(A, B, m, n);
        return computeIteratively(A, B,m,n);
        }

        //Recursive approach
        static int computeRecursively(String A, String B, int i, int j){
            //BASE CASE
            if(i==0) return j;
            if(j==0) return i;

            if(dp[i][j]!=0) return dp[i][j];

            //Compute
            if(A.charAt(i-1)==B.charAt(j-1)){
                dp[i][j]=computeRecursively(A,B,i-1,j-1);
            }
            else{
                int replace = computeRecursively(A, B, i-1, j-1);
                int delete = computeRecursively(A, B, i-1, j);
                int insert = computeRecursively(A, B, i, j-1);
                dp[i][j]=1+Math.min(replace, Math.min(insert,delete));
            }

            return dp[i][j];
        }

        //Iterative approach
        static int computeIteratively(String A, String B, int m, int n) {

            // +1 denotes cost of the operation

            //setting 1st column
            for(int i=1;i<=m;i++){
                dp[i][0]=dp[i-1][0]+1;
            }

            //setting 1st row
            for(int i=1;i<=n;i++){
                dp[0][i]=dp[0][i-1]+1;
            }

            for (int i =1;i<=m;i++ ){
                for (int j=1;j<=n;j++){
                    if (A.charAt(i-1)== B.charAt(j-1)){
                        dp[i][j] =  dp[i-1][j-1];
                    }else {
                        int replace = dp [i-1][j-1];
                        int delete = dp [i-1][j];
                        int insert = dp [i][j-1];
                        dp[i][j] = 1+ Math.min(replace, Math.min(delete, insert));
                    }
                }
            }
           return dp[m][n];
        }

    public static void main(String[] args) {
       // System.out.println(computeEditDistance("b","a"));
        //System.out.println(computeEditDistance("aac","abac"));
       // System.out.println(computeEditDistance("abad","abac"));
        System.out.println(computeEditDistance("Anshuman","Antihuman"));

    }
}
