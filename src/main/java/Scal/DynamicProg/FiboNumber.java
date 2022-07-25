package Scal.DynamicProg;

/** Fibonacci Number
 * Problem Description
 * Given a positive integer A, write a program to find the Ath Fibonacci number.
 * In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
 * NOTE: 0th term is 0. 1th term is 1 and so on.
 */

 public class FiboNumber {
    private static int data[];

    public static int solve(int n){
        data = new int [n+1];
        return compute(n);
    }
    private static int compute(int n){
        if (n<=1) return n;
        if (data[n] != 0) return data[n];
        data[n]= compute(n-1) + compute(n-2);
        return data[n];
    }

    public static void main(String[] args) {
        System.out.println(solve((6)));
    }
}
