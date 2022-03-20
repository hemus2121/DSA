package Scal.DynamicProg;

public class DiceThrow {
    static int mod  = (int) Math.pow(10,9)+ 7;

    private static  int getCount(int A){
        int []dp = new int[A+1];
        //base case
        dp[0]=1;
        for (int i =1;i<=A;i++){
            //dp[i]=0;
            for(int j =1;j<=6;j++){
                if (j<=i){
                    dp [i] = (dp[i]+ dp[i-j])%mod;
                }
            }
        }
        return dp[A];
    }
    public static void main(String[] args) {
        System.out.println(getCount(4));
    }
}
