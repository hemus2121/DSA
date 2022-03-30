package Scal.DynamicProg.TwoDArray;

public class CoinSumInfinite {
    static int coinchange2(int []A, int B){
        int mod  = (int) Math.pow(10, 6)+7;
        int n = A.length;
        int[][] dp=new int[n+1][B+1];

        for(int i=1;i<=B;i++){
            dp[0][i]=0;
        }
        // this is initalized to 1 since ZERO j it means thats we already got 1 way to get change which is zero
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=B;j++){
                if(j>=A[i-1]){
                    dp[i][j]=(dp[i-1][j]%mod+dp[i][j-A[i-1]]%mod)%mod;
                }
                else{
                    dp[i][j]=dp[i-1][j]%mod;
                }
            }
        }
        return (dp[n][B] %mod);
    }
    public static void main(String[] args) {
        int []  A ={ 1,2, 3};
        System.out.println(coinchange2(A,4));

    }
}
