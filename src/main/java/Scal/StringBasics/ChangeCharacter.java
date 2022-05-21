package Scal.StringBasics;

/* Change Character
Problem Description
You are given a string A of size N consisting of lowercase alphabets.
You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
Find the minimum number of distinct characters in the resulting string.
 */
import java.util.Arrays;

public class ChangeCharacter {
    private static int changeCharacterCount(String A, int B){
        //lets use freq array
        int [] freqArr = new int [26];
        int dst=0;
        for (char c : A.toCharArray()){
            freqArr[c-'a']++;
            if (freqArr[ c-'a']==1) dst++; //keeping track of distinct elements found so far in input
        }

        Arrays.sort(freqArr);
        for (int a : freqArr){
            if (a !=0){
                if (a > B) break;
                dst--;
                B= B-a;
            }
        }
        return dst;
    }

    public static void main(String[] args) {
        String A ="abcabbccd";
        //System.out.println(changeCharacterCount(A, 3));
        String AA ="wfnfozvsrt";
        System.out.println(changeCharacterCount(AA, 4));
    }
}
