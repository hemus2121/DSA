package Scal.Arrays;
/*
Least Common Multiple
Problem Description

You are given two non-negative integers, A and B. Find the value of the Least Common Multiple (LCM) of A and B.
LCM of two integers is the smallest positive integer divisible by both.

 */
public class LeastCommonMultiple {

    private static int computeLCM(int A, int B){
        return (A*B) / getGCD(A, B);
    }
    static int getGCD (int A, int B){
        if (B==0) return A;
        return getGCD(B, A%B);
    }

    public static void main(String[] args) {
        System.out.println(computeLCM(2, 3));
        System.out.println(computeLCM(9, 6));
        System.out.println(computeLCM(2, 6));
    }
}
