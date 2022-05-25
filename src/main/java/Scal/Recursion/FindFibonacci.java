package Scal.Recursion;

/**
 * Find Fibonacci - II
 * Problem Description
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
 * Fn = Fn-1 + Fn-2
 * Given a number A, find and return the Ath Fibonacci Number.
 * Given that F0 = 0 and F1 = 1.
 */
public class FindFibonacci {
    private static int getAthFibonacciNumber(int A) {
        return getFibonocci(A);
    }

    static int getFibonocci(int A){
     //Base case
     if (A==0) return 0;
     if (A==1) return 1;
     //Main Logic
     return getFibonocci(A-1) + getFibonocci(A-2);
    }

    public static void main(String[] args) {
     System.out.println(getAthFibonacciNumber(9)); //expected 34
    }

}
