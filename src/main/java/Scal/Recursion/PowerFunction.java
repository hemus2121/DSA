package Scal.Recursion;

/** Implement Power Function
 * Problem Description
 * Implement pow(A, B) % C.
 * In other words, given A, B and C, Find (AB % C).
 * Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
 */
public class PowerFunction {
    private static int getPower(int A, int B, int C){
        // corner case
        if (A ==0 ) return 0;
        //invoke recursive call
        long powerValue = computePower(A, B, C);
        if (powerValue <0) return (int)(powerValue +C) %C;
        return (int) powerValue%C;
    }

    //Recursive method
    private static long computePower(int A, int B, int C){
        //Base Case
        if (B==0) return 1;

        //MainLogic
        long tempPower = computePower(A, B/2, C);
        if (B%2==0){
            return ( tempPower * tempPower )%C;
        }else {
            return  (tempPower %C  * tempPower %C * A) %C;
        }
    }

    public static void main(String[] args) {
        System.out.println(getPower(2, 3, 3)); //expected =2
    }
}
