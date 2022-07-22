package Scal.Subsequence;

/** Littler Ponny and 2-Subsequence
 * Problem Description
 * Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?
 * A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".
 */
public class LittlePony {
    private static String getSubSequence(String A){
        if (A.length()<2) return A;
        char a = A.charAt(0);
        char b = A.charAt(1);
        int index =2;
        while (index < A.length()){
            if (b< a){
                a = b ;
                b = A.charAt(index);
            }else if (A.charAt(index)< b){
                b = A.charAt(index);
            }
            index++;
        }
        return ""+a+b;
    }
    public static void main(String[] args) {
        System.out.println(getSubSequence("abcdsfhjagj"));// expected aa
        System.out.println(getSubSequence("ksdjgha")); // expected da
    }
}
