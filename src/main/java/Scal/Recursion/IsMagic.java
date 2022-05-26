package Scal.Recursion;

/** Is Magic
 * Problem Description
 *
 * Given a number A, check if it is a magic number or not.
 *
 * A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by adding the sum of the digits after every addition.
 * If the single digit comes out to be 1, then the number is a magic number.
 */
public class IsMagic {

    /** One approach is to recursively check the sum of digits until a single digit is left.
     Now, check if the number is 1, then it is a magic number. Else NOT.

     Efficient Approach:
     There is also a shortcut method to verify Magic Number.
     The function will determine if the remainder of dividing the input by 9 is 1 or not.
     If it is 1, then the number is a magic number.
     The divisibility rule of 9 says that a number is divisible by 9 if the sum of its digits is also divisible by 9.
     Therefore, if a number is divisible by 9, then, recursively, all the digit sums are also divisible by 9.
     The final digit sum is always 9. An increase of 1 in the original number will increase the ultimate value by 1, making it 10, and the ultimate sum will be 1, thus verifying that it is a magic number.

     */
     private static int checkIsMagic(int n) {
        return (n % 9 == 1) ? 1 : 0;
    }
    public static void main(String[] args) {
        System.out.println(checkIsMagic(83557)); //expected 1
        System.out.println(checkIsMagic(1291)); //expected 0
    }
}
