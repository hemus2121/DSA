package Scal.Arrays.ArraysAndMaths;

/* A, B and Modulo

Problem Description
Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.

 */
public class ABModulo {
    private static int getModulo(int A,int B){
        return Math.abs(A-B);
    }
    public static void main(String[] args) {
        System.out.println(getModulo(1, 2));
        System.out.println(getModulo(5, 10));
    }
}
