package Scal.DynamicProg;
/*
Problem Description

In Danceland, one person can party either alone or can pair up with another person.
Can you find in how many ways they can party if there are A people in Danceland?

Note: Return your answer modulo 10003, as the answer can be large.
 */
public class Party {

    static int [] dp ;
    public static int solve(int A){
        dp = new int [A+1];
        // return (computePartyRecursion(A));
        return computePartyIterative(A);
    }
    //TOP DOWN approach
    static int computePartyRecursion(int n){
        //BASE Case
        if (n==1  || n==2) return n;

        //check if present in array
        if (dp[n]!=0) return dp[n];

        //compute
        dp[n] = ((n-1)* computePartyRecursion(n-2)+ 1* computePartyRecursion(n-1))%10003;
        return dp[n];
    }

    //BOTTOM UP approach
    static int computePartyIterative(int n){

        if (n==1) return 1;
        dp[1]=1;
        dp[2]=2;

        for (int i =3;i<=n;i++){
            dp [i]=  ((i-1) * dp[i-2] + 1 * dp[i-1])%10003;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(solve(17));
    }
}
