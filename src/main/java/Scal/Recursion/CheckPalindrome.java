package Scal.Recursion;

/**  Check Palindrome
Problem Description
Write a recursive function that checks whether string A is a palindrome or Not.
Return 1 if the string A is a palindrome, else return 0.
Note: A palindrome is a string that's the same when read forward and backward.
 */
public class CheckPalindrome {
    private static int checkPalindrome (String S){
        return isPalindrome(S, 0, S.length()-1);
    }
    static int isPalindrome(String s, int startIndex, int endIndex){
        // base case
        if (startIndex > endIndex) return 1;

        //Main logic - check for first character and iterate for others
        if ( s.charAt(startIndex) == s.charAt(endIndex)) {
            return isPalindrome(s, startIndex + 1, endIndex - 1);
        } else return 0;

    }
    public static void main(String[] args) {
        System.out.println(checkPalindrome("malayalam")); //expected 1
        System.out.println(checkPalindrome("madamm"));    //expected 0
    }
}