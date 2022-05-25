package Scal.Recursion;

/** Find Factorial
 * Problem Description
 *
 * Write a program to find the factorial of the given number A.
 */
public class FindFactorial {
    private static int getFactorial(int A){
        return computeFactorial(A);
    }
    static int computeFactorial(int A){
        //Base case
        if (A<=1) return 1;
        //Main Logic
        return  computeFactorial(A-1) *A;
    }
    public static void main(String[] args) {
        System.out.println(getFactorial(4)); //expected 24
    }
}
