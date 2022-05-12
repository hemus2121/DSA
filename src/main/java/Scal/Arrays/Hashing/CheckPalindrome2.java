package Scal.Arrays.Hashing;

import java.util.HashSet;
import java.util.Set;
/* Check Palindrome-2

Problem Description
Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 */
public class CheckPalindrome2 {
    private static int checkPalindrome(String A){

        //Basically odd length palindrome will ensure one element is unique and even length no unique elements
        int len = A.length();
        boolean isOdd=false;
        if (len%2==0) isOdd= false;

        Set<Character> hashSet = new HashSet<>();
        for (char c : A.toCharArray()){
            if (hashSet.contains(c)){
                hashSet.remove(c);
            }else hashSet.add(c);
        }

        System.out.println("len: "+ len +  " isOdd:" + isOdd + " remSize:"+ hashSet.size());
        //check for even /odd combination
        if (isOdd==false && hashSet.size()==1) return 1;
        if (isOdd==false && hashSet.size()==0) return 1;

        return 0;
    }
    public static void main(String[] args) {
        System.out.println(checkPalindrome("abcde"));
        System.out.println(checkPalindrome("abbaee"));
        System.out.println(checkPalindrome("aaaaa"));

    }
}
