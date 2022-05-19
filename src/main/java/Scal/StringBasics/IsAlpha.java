package Scal.StringBasics;

/* Isalpha()
Problem Description

You are given a function isalpha() consisting of a character array A.
Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.
 */
public class IsAlpha {
    private static int checkIsAlpha(char [] A){
        for (char a :A){
            int temp =a;
            if (! ( (temp >=65 && temp <=90) || (temp >=97 && temp <=122))){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        char [] data = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'}; //expected 1
        System.out.println(checkIsAlpha(data));
        char [] data1 = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'}; //expected 0
        System.out.println(checkIsAlpha(data1));

    }
}
