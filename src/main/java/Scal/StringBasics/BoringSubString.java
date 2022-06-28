package Scal.StringBasics;

/* Boring SubString
Problem Description

Given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:
    Its length is 2.
    Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).

Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.
 */

public class BoringSubString {
    private static int checkBoring(String A){
        int smallestodd=Integer.MAX_VALUE,largestodd=Integer.MIN_VALUE;
        int smallesteven=Integer.MAX_VALUE,largesteven=Integer.MIN_VALUE;


        for (char c : A.toCharArray()){
            int temp = (int)c;
            if (temp%2==0){
                //its even character
                if (temp < smallesteven) smallesteven=Math.min(smallesteven, temp);
                else if (temp > largesteven) largesteven=Math.max(largesteven,temp);
            }else {
                if (temp < smallestodd) smallestodd=Math.min(smallestodd,temp);
                else if (temp > largestodd) largestodd=Math.max(largestodd,temp);
            }
        }
       // System.out.println("smallesteven="+smallesteven + " largesteven="+largesteven);
        //System.out.println("smallestodd="+smallestodd + "  largestodd="+ largestodd);

        //conditions to check
        if (smallestodd >0 && largesteven >0 && Math.abs(smallestodd-largesteven )!=1) return 1;
       // else if (smallestodd >0 && largesteven>0 && Math.abs(smallestodd -largesteven) !=1) return 1;
        else if (largestodd >0 && smallesteven>0 && Math.abs(largestodd-smallesteven) !=1) return 1;
        //else if (largestodd>0 && largesteven>0&& Math.abs(largestodd-largesteven)!=1) return 1;
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(checkBoring("abcd"));
        System.out.println(checkBoring("aab"));
        System.out.println(checkBoring("ejbfb"));
    }
}
