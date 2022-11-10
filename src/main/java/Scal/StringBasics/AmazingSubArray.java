package Scal.StringBasics;

/* Amazing Subarrays
You are given a string S, and you have to find all the amazing substrings of S.
An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 */
public class AmazingSubArray {
    private static int getCountOfSubArrays(String A) {
        A = A.toLowerCase();
        int l = A.length();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if ((A.charAt(i) == 'a') || (A.charAt(i) == 'e') || (A.charAt(i) == 'i') || (A.charAt(i) == 'o') || (A.charAt(i) == 'u')) {
                sum += l - i;
                sum = sum % 10003;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getCountOfSubArrays("ABEC"));
    }
}
