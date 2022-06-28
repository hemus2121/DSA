package Scal.StringBasics;


/** Making String Palindrome
 * Problem Description
 * Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.
 *
 * Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.
 */
public class MakeStringPalindrome {

    //Using KMP algo - LPS array concept
    public static int getPalinCount(String A){
        StringBuilder sb = new StringBuilder(A);
        sb.reverse();
        String palin= A +"$"+sb; // append to original string reversed string with differenciator at middle
        return A.length() - checkPalin(palin);
    }

    private static int checkPalin(String palin){
        int [] lps = new int[palin.length()];
        lps[0] =0;
        int i =1, len=0;  // i denotes forward pointer and len prev pointer
        while (i<palin.length()){
            // check if both consecutive characters are equal-increment both pointers
            if (palin.charAt(i) == palin.charAt(len)){
                len ++;
                lps[i] = len;
                i++;
            }else {
                if (len !=0){ //if there is mismatch take to location where it last matched
                    len = lps[len-1];// take it back to location which is denoted by index of lps arrray
                }else{
                    i++; //increment forward pointer
                }
            }
        }
        return  lps[palin.length()-1];
    }
    public static void main(String[] args) {
        String A ="abc";
        System.out.println(getPalinCount(A)); //expected 2
    }
}
