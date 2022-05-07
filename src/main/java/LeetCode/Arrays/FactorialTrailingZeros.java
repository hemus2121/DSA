package LeetCode.Arrays;
/*
Factorial Trailing Zeroes -https://leetcode.com/problems/factorial-trailing-zeroes/
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

More reading - https://leetcode.com/problems/factorial-trailing-zeroes/discuss/1885083/Best-solution-Logn-with-Comments
 */
public class FactorialTrailingZeros {

    private static int countTrailingZeros(int n ){
        // we need to count multiple of 5's in specific number
        int count =0;
        while (n > 4){
            n = n /5;
            count = count +n;
        }
        return  count;
    }
    public static void main(String[] args) {
        System.out.println(countTrailingZeros(25));
    }
}
