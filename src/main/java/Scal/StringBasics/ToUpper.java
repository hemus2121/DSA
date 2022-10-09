package Scal.StringBasics;
/* To Upper
Problem Description

You are given a function to_upper() consisting of a character array A.
Convert each character of A into Uppercase character if it exists. If the Uppercase of a character does not exist, it remains unmodified.
The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.
Return the uppercase version of the given character array.
 */
public class ToUpper {
     private static char [] toUpper(char [] A){
         /*for (int i =0;i< A.length;i++){
             int temp = A[i]; // assign to int variable to get integer value
             if ( temp >=97 && temp < 122){
                  A[i] = (char) (temp -32);
             }
         }
         return A;*/

         for (int i =0;i< A.length;i++){
             if ( A[i] >='a' && A[i] <= 'z'){
                 A[i] ^= 32;
             }
         }
         return A;
     }
    public static void main(String[] args) {
        char [] data = {'s','c','a','l','e','r'};
        System.out.println(toUpper(data));
    }
}
