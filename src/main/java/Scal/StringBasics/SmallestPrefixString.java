package Scal.StringBasics;

/**  Smallest Prefix String
 * Problem Description
 * Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
 * Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.
 */
public class SmallestPrefixString {
    private static String getSmallestPrefixString(String A, String B){
        String res = ""+A.charAt(0); // append 1st character as mentioned in question
        int i =1;
        while (i < A.length() && A.charAt(i) < B.charAt(0)){ // iterate until A length and A char is less than B character
            res += A.charAt(i);
            i++;
        }
        return res +B.charAt(0); // Append B 1st character
    }

    public static void main(String[] args) {
        String A = "abba" , B = "cdd";
        System.out.println(getSmallestPrefixString(A, B)); //expected "abbac"
    }
}
