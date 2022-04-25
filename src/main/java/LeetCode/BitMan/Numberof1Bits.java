package LeetCode.BitMan;

/*
Number of 1 Bits -- https://leetcode.com/problems/number-of-1-bits/
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:
In some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 */

public class Numberof1Bits {
    private static int getCount(int n){
        int count =0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return  count;
    }

    private static int getCount2(int n){
        int count =0;
        for (int i =0;i< 32;i++){
            if( (n & 1)==1) count++;
            n = n>>1;
        }
        return  count;
    }
    public static void main(String[] args) {
        System.out.println(getCount(00000000000000000000000000001011));
        System.out.println(getCount2(00000000000000000000000000001011));
    }
}
