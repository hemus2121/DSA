package Scal.BitMan;
/* Single Number
Problem Description
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {

    public static int getSingleNumber(final int [] A){
        int result = 0;
        for(int a: A){
            result = result ^ a;
        }
        return result;
    }
    public static void main(String[] args) {
        int [] data =  {1, 2, 2};
        System.out.println(getSingleNumber(data)); //expected 1
    }
}
