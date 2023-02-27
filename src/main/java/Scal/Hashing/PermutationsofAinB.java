package Scal.Hashing;

/* Permutations of A in B
Problem Description
You are given two strings, A and B, of size N and M, respectively.
You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
 */
public class PermutationsofAinB {

    private static int getCountOfPermutations(String A, String B){

        //check if length are differnt return 0
        if (A.length() > B.length()){
            return 0;
        }

        int[] freqA = new int [26];
        int[] freqB = new int [26];

        //build freq array for both string of length equal to shorter length
        for (int i =0;i< A.length();i++){
            freqA[A.charAt(i)-'a']++;
            freqB[B.charAt(i)-'a']++;
        }

        int result =0;
        for ( int i =0;i<B.length()-A.length();i++){
            if (matches (freqA, freqB)){
                result++;
            }
            // move the sliding window
            //increase freq of incomng element
            freqB[B.charAt(i+ A.length())-'a']++;
            freqB[B.charAt(i)-'a']--;
        }
        //handle for last window which is not covered in for loop
        if (matches(freqA, freqB)) result++;
        return result;
    }

    static boolean matches (int [] freqA, int [] freqB){
        for (int i =0;i< 26;i++){
            if (freqA[i]!= freqB[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 ="abc";
        String s2 = "abcbacabc";
        System.out.println(getCountOfPermutations(s1, s2)); //expected 5
    }
}
