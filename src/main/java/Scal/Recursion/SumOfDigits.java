package Scal.Recursion;
/* sum Of Digits
Problem Description
Given a number A, we need to find the sum of its digits using recursion.
 */
public class SumOfDigits {
    static int sumOfDigits(int A){
        return computeSum(A);
    }
    static int computeSum(int A){
        // Base case
        if ( A==0) return 0;
        if (A < 9) return A;
        //Main Logic
        // Add remainder to (number /A)
        return A%10 + computeSum(A/10);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(64)); //expected 10
    }
}
