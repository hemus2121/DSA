package Scal.Arrays.PFSumCarryForward;
/*
Special Subsequences "AG"

Problem Description
You have given a string A having Uppercase English letters.
You have to find how many times subsequence "AG" is there in the given string.
NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 */
public class SpecialSequenceAG {
     static  int  getSpecialSequence(String A){
         int ans =0, count =0;
         int mod = (int) Math.pow(10,9)+7;

         //lets iterate from RHS to reduce Time complexity
         for (int i =A.length()-1;i>=0;i--){
             if (A.charAt(i)=='G'){
                 count++;
             }else if (A.charAt(i)=='A'){
                 ans = (count %mod + ans%mod)%mod;
             }
         }
         return ans;
    }
    public static void main(String[] args) {
        System.out.println(getSpecialSequence("ABCGAG"));
    }
}
