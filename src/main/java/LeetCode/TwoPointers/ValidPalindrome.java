package LeetCode.TwoPointers;
/*  Valid Palindrome - https://leetcode.com/problems/valid-palindrome/

    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s){
        //create a new string out of input String
        char [] charData = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charData) {
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        String dataString = sb.toString();
        //using 2 pointers
        int i =0; int j = dataString.length()-1;
        while (i <j){
            if (dataString.charAt(i++) != dataString.charAt(j--))
                return  false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        String s1 ="race a car";
        System.out.println(isPalindrome(s1));
    }
}
