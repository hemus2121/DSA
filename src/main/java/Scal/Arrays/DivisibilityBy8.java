package Scal.Arrays;
/* Divisibility by 8

Problem Description
You are given a number A in the form of a string. Check if the number is divisible by eight or not.
Return 1 if it is divisible by eight else, return 0.
 */
public class DivisibilityBy8 {
    private static int checkDivisibility (String A){
        // Logic is
        // 1. Length of string is less than 3 than convert it to Integer and check remainder
        // 2. check for last 3 digits whether they are divisible by 8

        int ans =0;
        int len = A.length();
        if (len <3){
            ans = Integer.parseInt(A);
        }else {
            ans = Integer.parseInt(A.substring(len-3));
        }
        return (ans%8==0)? 1:0;

    }
    public static void main(String[] args) {
        System.out.println(checkDivisibility("32768"));
    }
}
