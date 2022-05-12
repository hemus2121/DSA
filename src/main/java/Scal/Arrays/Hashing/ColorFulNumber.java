package Scal.Arrays.Hashing;

import java.util.*;
/* ColorFul Number
Problem Description
Given a number A, find if it is COLORFUL number or not.
If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:
A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
 */

public class ColorFulNumber {
    private static int checkColorFulNumber(int A){

        //Convert integer to String for easy iteration
        String inputString = Integer.toString(A);
        Set <Integer> productSet = new HashSet<>();
        for (int i =0;i< inputString.length();i++){
            int product =1;
            for (int j =i;j< inputString.length();j++){
                int num = inputString.charAt(j)-'0'; // to get integer equivalent of Character
                product = product * num;
                if (productSet.contains(product)) return 0;
                else productSet.add(product);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(checkColorFulNumber(23)); //expected =1
        System.out.println(checkColorFulNumber(236)); //expected =0
    }
}
