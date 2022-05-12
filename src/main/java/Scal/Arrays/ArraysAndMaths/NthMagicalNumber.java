package Scal.Arrays.ArraysAndMaths;
/* Nth Magical Number
Problem Description
Given an integer A, find and return the Ath magic number.
A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 */
public class NthMagicalNumber {
    private static int getMagicalNumber(int A){
        int x =1;
        int ans =0;
        //based on binary representation - ie.e base 5 2nd number is 25 is 011
        while (A>0) {
            x = x *5;
            //for odd number
            if (A %2==1) ans = ans + x;
            // devide/2 original number to reduce
            A = A >>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getMagicalNumber(10)); // expected 650
    }
}
