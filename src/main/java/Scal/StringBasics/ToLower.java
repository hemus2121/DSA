package Scal.StringBasics;

/* toLower()
Problem Description

You are given a function to_lower() which takes a character array A as an argument.
Convert each character of A into lowercase characters if it exists. If the lowercase of a character does not exist, it remains unmodified.
The uppercase letters from A to Z are converted to lowercase letters from a to z respectively.
Return the lowercase version of the given character array.
 */

public class ToLower {
    private static char [] toLower(char [] A){

        for (int i=0;i < A.length;i++){
            int temp = A[i];// assign to int variable to get integer value
            if ( temp >=65 && temp < 91){
                A[i] = (char)(temp + 32);
            }
        }
        return A;
    }
    public static void main(String[] args) {
        char [] data = { 'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'};
        System.out.println(toLower(data));
    }
}
