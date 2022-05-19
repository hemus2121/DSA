package Scal.StringBasics;
/*  Isalnum()
Problem Description
You are given a function isalpha() consisting of a character array A.
Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.

 */
public class IsAlphaNum {
    private static int checkAlphaNum(char []A){
        for (char c : A){
            int temp = c;
            //check for capital char range - (65-90), small char range (97-122) and number (48-59) inclusive
            if (!( (temp >=65  && temp <=90) || (temp >=97 && temp <=122) || (temp >=48 && temp <=57))){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
     char [] data = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'}; //expected 1
       System.out.println(checkAlphaNum(data));
       char [] data1 = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'}; //expected 0
       System.out.println(checkAlphaNum(data1));
       char [] data2={ 's', 'g', '7', 'A', 'd', 'v', 't', 'W', '4', 'A', '4', '2', '8', 'f', 'h', 'B', 'p', 'h', '7', '0', 'v', 'q', 'w', '9', 'o'}; //expected 1
        System.out.println(checkAlphaNum(data2));
    }
}
