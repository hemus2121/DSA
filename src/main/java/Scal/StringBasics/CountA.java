package Scal.StringBasics;

/** Count A
 * Problem Description
 * You are given a string A. Find the number of substrings that start and end with 'a'.
 */
public class CountA {

    private static int countOfA(String S){
        int countofA=0;
        for (char c : S.toCharArray()){
            if (c =='a') countofA++;
        }
        return  ( countofA * (countofA+1))/2;
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(countOfA(s)); //expected 3
    }
}
